package com.example.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class GreetingClient {
    public static void main(String[] args) {
        System.out.println("Greeting Client ");

        GreetingClient main = new GreetingClient();
        main.run();

    }
    private void run()
    {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        doBiDiStreamingCall(channel);
        System.out.println("Shutting down");
        channel.shutdown();
    }

    private void doBiDiStreamingCall(ManagedChannel channel)
    {
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<GreetEveryoneRequest> requestObserver = asyncClient.greetEveryone(new StreamObserver<GreetEveryoneResponse>() {
            @Override
            public void onNext(GreetEveryoneResponse value) {
                System.out.println("Hello from server "+ value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server is done sending data ");
                latch.countDown();
            }
        });
        Arrays.asList("Nishi", "Puchu", "Faru", "pd", "habijabi").forEach(
                name -> {
                    System.out.println("Sending to server : "+ name);
                    requestObserver.onNext(GreetEveryoneRequest
                            .newBuilder()
                            .setGreeting(Greeting.newBuilder()
                                    .setFirstName(name))
                            .build());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        requestObserver.onCompleted();

        try {
            latch.await(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
