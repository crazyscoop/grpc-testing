package protos.hello_world;


import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloResponse;
import io.grpc.examples.helloworld.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void hello(
        HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    System.out.println("Request received from client:\n" + request);

    String greeting = new StringBuilder().append("Hello, ")
          .append(request.getFirstName())
          .append(" ")
          .append(request.getLastName())
          .toString();

    HelloResponse response = HelloResponse.newBuilder()
          .setGreeting(greeting)
          .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

}
