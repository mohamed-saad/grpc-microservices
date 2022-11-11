package com.simple.compute;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ComputeService {
    private static final Logger logger = Logger.getLogger(ComputeService.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length == 0) {
            System.err.println("Missing argument, please specify the port");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);
        String id =  "compute@"+port;

        Server server = ServerBuilder.forPort(port).addService(new ComputerGrpc.ComputerImplBase() {
            @Override
            public void compute(Compute.ComputationInput request, StreamObserver<Compute.ComputationResult> responseObserver) {
                logger.info("Compute Request " + request);
                try { Thread.sleep((long)(Math.random() * 2000)); } catch (InterruptedException e) {}
                Compute.ComputationResult result = Compute.ComputationResult.newBuilder()
                        .setId(id)
                        .setResult(request.getX() + request.getY())
                        .build();
                logger.info("Computed Result " + result);
                responseObserver.onNext(result);
                responseObserver.onCompleted();
            }
        }).build().start();

        logger.info("Compute service " + id + " started, listening on " + port);

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
