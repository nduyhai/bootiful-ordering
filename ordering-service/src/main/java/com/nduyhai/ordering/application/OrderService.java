package com.nduyhai.ordering.application;

import com.nduyhai.ordering.domain.Order;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
  Optional<Order> getOrder(UUID orderId);

  Order createOrder(Order order);

  void cancel(UUID orderId);

  void confirmed(UUID orderId);
}
