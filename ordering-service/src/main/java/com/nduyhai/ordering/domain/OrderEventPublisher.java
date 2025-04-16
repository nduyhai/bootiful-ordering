package com.nduyhai.ordering.domain;

public interface OrderEventPublisher {
  void onChange(Order order);
}
