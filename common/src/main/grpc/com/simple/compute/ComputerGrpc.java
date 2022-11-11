package com.simple.compute;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.50.2)",
    comments = "Source: compute.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ComputerGrpc {

  private ComputerGrpc() {}

  public static final String SERVICE_NAME = "Computer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.simple.compute.Compute.ComputationInput,
      com.simple.compute.Compute.ComputationResult> getComputeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "compute",
      requestType = com.simple.compute.Compute.ComputationInput.class,
      responseType = com.simple.compute.Compute.ComputationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.simple.compute.Compute.ComputationInput,
      com.simple.compute.Compute.ComputationResult> getComputeMethod() {
    io.grpc.MethodDescriptor<com.simple.compute.Compute.ComputationInput, com.simple.compute.Compute.ComputationResult> getComputeMethod;
    if ((getComputeMethod = ComputerGrpc.getComputeMethod) == null) {
      synchronized (ComputerGrpc.class) {
        if ((getComputeMethod = ComputerGrpc.getComputeMethod) == null) {
          ComputerGrpc.getComputeMethod = getComputeMethod =
              io.grpc.MethodDescriptor.<com.simple.compute.Compute.ComputationInput, com.simple.compute.Compute.ComputationResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "compute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simple.compute.Compute.ComputationInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simple.compute.Compute.ComputationResult.getDefaultInstance()))
              .setSchemaDescriptor(new ComputerMethodDescriptorSupplier("compute"))
              .build();
        }
      }
    }
    return getComputeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ComputerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComputerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComputerStub>() {
        @java.lang.Override
        public ComputerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComputerStub(channel, callOptions);
        }
      };
    return ComputerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ComputerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComputerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComputerBlockingStub>() {
        @java.lang.Override
        public ComputerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComputerBlockingStub(channel, callOptions);
        }
      };
    return ComputerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ComputerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComputerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ComputerFutureStub>() {
        @java.lang.Override
        public ComputerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ComputerFutureStub(channel, callOptions);
        }
      };
    return ComputerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ComputerImplBase implements io.grpc.BindableService {

    /**
     */
    public void compute(com.simple.compute.Compute.ComputationInput request,
        io.grpc.stub.StreamObserver<com.simple.compute.Compute.ComputationResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getComputeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.simple.compute.Compute.ComputationInput,
                com.simple.compute.Compute.ComputationResult>(
                  this, METHODID_COMPUTE)))
          .build();
    }
  }

  /**
   */
  public static final class ComputerStub extends io.grpc.stub.AbstractAsyncStub<ComputerStub> {
    private ComputerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComputerStub(channel, callOptions);
    }

    /**
     */
    public void compute(com.simple.compute.Compute.ComputationInput request,
        io.grpc.stub.StreamObserver<com.simple.compute.Compute.ComputationResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ComputerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ComputerBlockingStub> {
    private ComputerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComputerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.simple.compute.Compute.ComputationResult compute(com.simple.compute.Compute.ComputationInput request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ComputerFutureStub extends io.grpc.stub.AbstractFutureStub<ComputerFutureStub> {
    private ComputerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComputerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.simple.compute.Compute.ComputationResult> compute(
        com.simple.compute.Compute.ComputationInput request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ComputerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ComputerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE:
          serviceImpl.compute((com.simple.compute.Compute.ComputationInput) request,
              (io.grpc.stub.StreamObserver<com.simple.compute.Compute.ComputationResult>) responseObserver);
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

  private static abstract class ComputerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ComputerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.simple.compute.Compute.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Computer");
    }
  }

  private static final class ComputerFileDescriptorSupplier
      extends ComputerBaseDescriptorSupplier {
    ComputerFileDescriptorSupplier() {}
  }

  private static final class ComputerMethodDescriptorSupplier
      extends ComputerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ComputerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ComputerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ComputerFileDescriptorSupplier())
              .addMethod(getComputeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
