package com.nduyhai.product.domain;

import org.jmolecules.event.annotation.DomainEventPublisher;

public interface ProductEventPublisher {
  @DomainEventPublisher
  void publishEvent(Product product);
}
