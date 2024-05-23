package com.nduyhai.customer;

import com.nduyhai.grpc.Customer;
import com.nduyhai.grpc.CustomerServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
@Slf4j
public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{

    @Override
    public void register(Customer.CreateUserRequest request, StreamObserver<Customer.CreateUserResponse> responseObserver) {
        try {
            Customer.CreateUserResponse response = Customer.CreateUserResponse.newBuilder()
                    .setUserId("123")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            log.info("Create user completed");
        } catch (Exception ex) {
            responseObserver.onError(ex);
        }
    }
}
