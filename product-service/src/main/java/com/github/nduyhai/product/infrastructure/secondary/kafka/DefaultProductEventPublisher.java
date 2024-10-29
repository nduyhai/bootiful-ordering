package com.github.nduyhai.product.infrastructure.secondary.kafka;

import com.github.nduyhai.product.domain.Product;
import com.github.nduyhai.product.domain.ProductEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultProductEventPublisher implements ProductEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;
  private final KafkaEventMapper kafkaEventMapper;

  @Override
  public void publishEvent(Product product) {
    this.applicationEventPublisher.publishEvent(this.kafkaEventMapper.fromDomain(product));
  }
}
