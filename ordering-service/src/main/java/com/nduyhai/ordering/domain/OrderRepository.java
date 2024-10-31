package com.nduyhai.ordering.domain;

import com.nduyhai.common.enumeration.OrderStatus;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
  Order createOrder(Order order);

  Order updateStatus(UUID orderId, OrderStatus status);

  Optional<Order> getById(UUID id);
}
