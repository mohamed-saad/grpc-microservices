package com.simple.audit;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: audit.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AuditorGrpc {

  private AuditorGrpc() {}

  public static final String SERVICE_NAME = "Auditor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.simple.audit.Audit.AuditInput,
      com.simple.audit.Audit.AuditResult> getAuditMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "audit",
      requestType = com.simple.audit.Audit.AuditInput.class,
      responseType = com.simple.audit.Audit.AuditResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.simple.audit.Audit.AuditInput,
      com.simple.audit.Audit.AuditResult> getAuditMethod() {
    io.grpc.MethodDescriptor<com.simple.audit.Audit.AuditInput, com.simple.audit.Audit.AuditResult> getAuditMethod;
    if ((getAuditMethod = AuditorGrpc.getAuditMethod) == null) {
      synchronized (AuditorGrpc.class) {
        if ((getAuditMethod = AuditorGrpc.getAuditMethod) == null) {
          AuditorGrpc.getAuditMethod = getAuditMethod =
              io.grpc.MethodDescriptor.<com.simple.audit.Audit.AuditInput, com.simple.audit.Audit.AuditResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "audit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simple.audit.Audit.AuditInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simple.audit.Audit.AuditResult.getDefaultInstance()))
              .setSchemaDescriptor(new AuditorMethodDescriptorSupplier("audit"))
              .build();
        }
      }
    }
    return getAuditMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.simple.audit.Audit.HistoryInput,
      com.simple.audit.Audit.HistoryResult> getHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "history",
      requestType = com.simple.audit.Audit.HistoryInput.class,
      responseType = com.simple.audit.Audit.HistoryResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.simple.audit.Audit.HistoryInput,
      com.simple.audit.Audit.HistoryResult> getHistoryMethod() {
    io.grpc.MethodDescriptor<com.simple.audit.Audit.HistoryInput, com.simple.audit.Audit.HistoryResult> getHistoryMethod;
    if ((getHistoryMethod = AuditorGrpc.getHistoryMethod) == null) {
      synchronized (AuditorGrpc.class) {
        if ((getHistoryMethod = AuditorGrpc.getHistoryMethod) == null) {
          AuditorGrpc.getHistoryMethod = getHistoryMethod =
              io.grpc.MethodDescriptor.<com.simple.audit.Audit.HistoryInput, com.simple.audit.Audit.HistoryResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "history"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simple.audit.Audit.HistoryInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simple.audit.Audit.HistoryResult.getDefaultInstance()))
              .setSchemaDescriptor(new AuditorMethodDescriptorSupplier("history"))
              .build();
        }
      }
    }
    return getHistoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuditorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuditorStub>() {
        @java.lang.Override
        public AuditorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuditorStub(channel, callOptions);
        }
      };
    return AuditorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuditorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuditorBlockingStub>() {
        @java.lang.Override
        public AuditorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuditorBlockingStub(channel, callOptions);
        }
      };
    return AuditorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuditorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuditorFutureStub>() {
        @java.lang.Override
        public AuditorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuditorFutureStub(channel, callOptions);
        }
      };
    return AuditorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AuditorImplBase implements io.grpc.BindableService {

    /**
     */
    public void audit(com.simple.audit.Audit.AuditInput request,
        io.grpc.stub.StreamObserver<com.simple.audit.Audit.AuditResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuditMethod(), responseObserver);
    }

    /**
     */
    public void history(com.simple.audit.Audit.HistoryInput request,
        io.grpc.stub.StreamObserver<com.simple.audit.Audit.HistoryResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHistoryMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuditMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.simple.audit.Audit.AuditInput,
                com.simple.audit.Audit.AuditResult>(
                  this, METHODID_AUDIT)))
          .addMethod(
            getHistoryMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.simple.audit.Audit.HistoryInput,
                com.simple.audit.Audit.HistoryResult>(
                  this, METHODID_HISTORY)))
          .build();
    }
  }

  /**
   */
  public static final class AuditorStub extends io.grpc.stub.AbstractAsyncStub<AuditorStub> {
    private AuditorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditorStub(channel, callOptions);
    }

    /**
     */
    public void audit(com.simple.audit.Audit.AuditInput request,
        io.grpc.stub.StreamObserver<com.simple.audit.Audit.AuditResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuditMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void history(com.simple.audit.Audit.HistoryInput request,
        io.grpc.stub.StreamObserver<com.simple.audit.Audit.HistoryResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getHistoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuditorBlockingStub extends io.grpc.stub.AbstractBlockingStub<AuditorBlockingStub> {
    private AuditorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditorBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.simple.audit.Audit.AuditResult audit(com.simple.audit.Audit.AuditInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuditMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.simple.audit.Audit.HistoryResult> history(
        com.simple.audit.Audit.HistoryInput request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getHistoryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuditorFutureStub extends io.grpc.stub.AbstractFutureStub<AuditorFutureStub> {
    private AuditorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.simple.audit.Audit.AuditResult> audit(
        com.simple.audit.Audit.AuditInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuditMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUDIT = 0;
  private static final int METHODID_HISTORY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuditorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuditorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUDIT:
          serviceImpl.audit((com.simple.audit.Audit.AuditInput) request,
              (io.grpc.stub.StreamObserver<com.simple.audit.Audit.AuditResult>) responseObserver);
          break;
        case METHODID_HISTORY:
          serviceImpl.history((com.simple.audit.Audit.HistoryInput) request,
              (io.grpc.stub.StreamObserver<com.simple.audit.Audit.HistoryResult>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AuditorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuditorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.simple.audit.Audit.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Auditor");
    }
  }

  private static final class AuditorFileDescriptorSupplier
      extends AuditorBaseDescriptorSupplier {
    AuditorFileDescriptorSupplier() {}
  }

  private static final class AuditorMethodDescriptorSupplier
      extends AuditorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuditorMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuditorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuditorFileDescriptorSupplier())
              .addMethod(getAuditMethod())
              .addMethod(getHistoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
