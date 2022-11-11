package com.simple.audit;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class AuditService {
    private static final Logger logger = Logger.getLogger(AuditService.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length == 0) {
            System.err.println("Missing argument, please specify the port");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);

        Server server = ServerBuilder.forPort(port).addService(new AuditorGrpc.AuditorImplBase() {
            class AuditEntry {
                long timestamp;
                String record;
            }

            List<AuditEntry> history = new LinkedList<>();

            @Override
            public void audit(Audit.AuditInput request, StreamObserver<Audit.AuditResult> responseObserver) {
                AuditEntry entry = new AuditEntry();
                entry.timestamp = request.getTimestamp();
                entry.record = String.format("received '%d' from '%s' in %d millis", request.getResult(),  request.getId(), request.getResponseTime()) ;
                history.add(0, entry);
                logger.info("Audit Request " + request);
                responseObserver.onNext(Audit.AuditResult.newBuilder().setSuccess(true).build());
                responseObserver.onCompleted();
            }

            @Override
            public void history(Audit.HistoryInput request, StreamObserver<Audit.HistoryResult> responseObserver) {
                logger.info("History Request " + request);
                int count = request.getMaxResult();
                Iterator<AuditEntry> itr = history.iterator();
                while (count-- > 0 && itr.hasNext()) {
                    AuditEntry entry = itr.next();
                    Audit.HistoryResult historyResult = Audit.HistoryResult.newBuilder().setRecord(entry.record).setTimestamp(entry.timestamp).build();
                    responseObserver.onNext(historyResult);
                }
                responseObserver.onCompleted();
            }
        }).build().start();

        logger.info("Audit service started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC server");
                try {
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        });

        server.awaitTermination();
    }
}
