package com.example.grpc.greeting.client;

import com.example.grpc.greeting.server.GreetServiceImpl;
import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class GreetingClient {
    public static void main(String[] args) {
        System.out.println("Greeting Client ");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
//        DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(channel);

        // Created a greet service client blocking - sync
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);

        // Created  a protocol buffer message
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Nishi")
                .setLastName("Puchu")
                .build();

        // create rpc request

        GreetRequest greetRequest = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();

        //  Call  a RPC and get back a GreetResponse
        GreetResponse greetResponse = greetClient.greet(greetRequest);

        // printout the result

        System.out.println(greetResponse.getResult());

        System.out.println("Shutting down");
        channel.shutdown();
    }
}
