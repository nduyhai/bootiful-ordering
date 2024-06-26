package com.nduyhai.inventory;

import brave.Tracing;
import brave.grpc.GrpcTracing;
import io.grpc.ServerInterceptor;
import org.lognet.springboot.grpc.GRpcGlobalInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {
  @Bean
  @GRpcGlobalInterceptor
  public ServerInterceptor tracingServerInterceptor(Tracing tracing) {
    return GrpcTracing.create(tracing).newServerInterceptor();
  }
}
