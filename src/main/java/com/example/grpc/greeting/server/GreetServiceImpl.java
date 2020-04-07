package com.example.grpc.greeting.server;

import com.proto.greet.GreetEveryoneRequest;
import com.proto.greet.GreetEveryoneResponse;
import com.proto.greet.GreetServiceGrpc.GreetServiceImplBase;
import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceImplBase {

    @Override
    public StreamObserver<GreetEveryoneRequest> greetEveryone( StreamObserver<GreetEveryoneResponse> responseObserver) {
//        super.greetEveryone(request, responseObserver);
        StreamObserver<GreetEveryoneRequest> requestObserver =
                new StreamObserver<GreetEveryoneRequest>() {
                    @Override
                    public void onNext(GreetEveryoneRequest value) {
                        String result = "Hello " + value.getGreeting().getFirstName();
                        GreetEveryoneResponse greetEveryoneResponse = GreetEveryoneResponse.newBuilder()
                                .setResult(result)
                                .build();
                        responseObserver.onNext(greetEveryoneResponse);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {
                        responseObserver.onCompleted();
                    }

                };
             return requestObserver;
    }
}
