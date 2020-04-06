package com.example.grpc.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC");

        Server server = ServerBuilder.forPort(50051).build();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread( () -> {
            System.out.println("REcived the shudown request");
            server.shutdown();
            System.out.println("Shutdown the server successfully");
        }));

        server.awaitTermination();

///Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home
    }
}
