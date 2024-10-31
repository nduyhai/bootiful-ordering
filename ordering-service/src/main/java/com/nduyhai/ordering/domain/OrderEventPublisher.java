package com.nduyhai.ordering.domain;

public interface OrderEventPublisher {
  void onConfirmed(Order order);
}
