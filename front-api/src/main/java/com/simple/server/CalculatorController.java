package com.simple.server;

import com.simple.audit.Audit;
import com.simple.audit.AuditorGrpc;
import com.simple.common.Base;
import com.simple.compute.Compute;
import com.simple.compute.ComputerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class CalculatorController {

    private static final Logger logger = Logger.getLogger(CalculatorController.class.getName());

    private final List<ComputerGrpc.ComputerBlockingStub> computerStubs = new LinkedList<>();
    private final AuditorGrpc.AuditorBlockingStub auditorStub;
    private final ExecutorService executorService;

    public CalculatorController(){
        List<ManagedChannel> channels = new LinkedList<>();

        ManagedChannel auditChannel = ManagedChannelBuilder.forTarget(ServerApplication.auditNode)
                .usePlaintext()
                .build();
        auditorStub = AuditorGrpc.newBlockingStub(auditChannel);
        channels.add(auditChannel);

        for (String computeNode: ServerApplication.computeNodes) {
            ManagedChannel computeChannel = ManagedChannelBuilder.forTarget(computeNode)
                    .usePlaintext()
                    .build();
            computerStubs.add(ComputerGrpc.newBlockingStub(computeChannel));
            channels.add(auditChannel);
        }

        executorService = Executors.newFixedThreadPool(computerStubs.size());

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC clients");
                for (ManagedChannel managedChannel: channels) {
                    try {
                        managedChannel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.err);
                    }
                }
                executorService.shutdown();
                try {
                    if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    @GetMapping("/network")
    String network() {
        return "Connected to Audit microservice at " + ServerApplication.auditNode +". " +
                "Connected to " + ServerApplication.computeNodes.length +
                " Compute microservices at " + Arrays.toString(ServerApplication.computeNodes);
    }

    @GetMapping("/history")
    List<String> history() {
        Audit.HistoryInput historyInput = Audit.HistoryInput.newBuilder()
                .setMaxResult(100)
                .build();
        List<String> history = new LinkedList<>();
        auditorStub.history(historyInput).forEachRemaining(item -> history.add(item.getTimestamp() + ": " + item.getRecord()));
        return history;
    }

    @GetMapping("/calculate")
    Integer calculate(@RequestParam(defaultValue="0") Integer x, @RequestParam(defaultValue="0") Integer y) throws InterruptedException, ExecutionException {
        // compute
        long start = System.currentTimeMillis();
        Compute.ComputationInput computationInput = Compute.ComputationInput.newBuilder()
                .setX(x)
                .setY(y)
                .setOperator(Base.OPERATOR.ADD)
                .build();

        ExecutorCompletionService<Compute.ComputationResult> contest = new ExecutorCompletionService(executorService);
        List<Future<Compute.ComputationResult>>  tasks = computerStubs.stream()
                .map(stub -> (Callable<Compute.ComputationResult>) () -> {
                            try { return stub.compute(computationInput); }
                            catch (Exception e) { return null;  }
                        })
                .map(contest::submit)
                .collect(Collectors.toList());
        Compute.ComputationResult computationResult = null;
        for (int i=0; i<computerStubs.size() && computationResult == null; i++) {
            computationResult = contest.take().get();
            logger.info("Got response " + computationResult + " on " + x + "+" + y);
        }
        for (Future<Compute.ComputationResult> task : tasks) {
            task.cancel(true);
        }
        if (computationResult == null) throw new RuntimeException("Failed to find a computation node");
        Integer result = computationResult.getResult();
        long end = System.currentTimeMillis();

        // audit
        Audit.AuditInput auditInput = Audit.AuditInput.newBuilder()
                .setId(computationResult.getId())
                .setResponseTime(end - start)
                .setResult(result)
                .setTimestamp(start)
                .build();
        auditorStub.audit(auditInput);

        // response
        return result;
    }
}
