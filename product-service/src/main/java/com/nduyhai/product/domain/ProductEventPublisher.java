package com.nduyhai.product.domain;

public interface ProductEventPublisher {
  void publishEvent(Product product);
}
