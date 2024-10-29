package com.github.nduyhai.product.domain;

public interface ProductEventPublisher {
  void publishEvent(Product product);
}
