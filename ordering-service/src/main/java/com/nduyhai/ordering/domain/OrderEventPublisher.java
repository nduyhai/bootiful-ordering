package com.nduyhai.ordering.domain;

public interface OrderEventPublisher {
  void publishEvent(Order order);
}
