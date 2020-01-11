package org.apache.skywalking.apm.testcase.grpc.provider.service;

import io.grpc.stub.StreamObserver;
import org.apache.skywalking.apm.testcase.grpc.proto.GreeterBlockingErrorGrpc;
import org.apache.skywalking.apm.testcase.grpc.proto.GreeterBlockingGrpc;
import org.apache.skywalking.apm.testcase.grpc.proto.HelloReply;
import org.apache.skywalking.apm.testcase.grpc.proto.HelloRequest;

public class GreeterBlockingErrorServiceImpl extends GreeterBlockingErrorGrpc.GreeterBlockingErrorImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        responseObserver.onNext(HelloReply.newBuilder().setMessage("Hi," + request.getName()).build());
        responseObserver.onError(new Exception());
        responseObserver.onCompleted();
    }
}
