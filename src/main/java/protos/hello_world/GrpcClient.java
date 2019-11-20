package protos.hello_world;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloResponse;
import io.grpc.examples.helloworld.HelloServiceGrpc;

public class GrpcClient {

  public static void main(String[] args) throws InterruptedException {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
          .usePlaintext()
          .build();

    HelloServiceGrpc.HelloServiceBlockingStub stub
          = HelloServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
          .setFirstName("Baeldung")
          .setLastName("gRPC")
          .build());

    System.out.println("Response received from server:\n" + helloResponse);

    channel.shutdown();
  }
}
