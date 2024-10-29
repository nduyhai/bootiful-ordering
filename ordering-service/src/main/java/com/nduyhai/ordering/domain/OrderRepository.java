package com.nduyhai.ordering.domain;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
  Order createOrder(Order order);

  Order cancelOder(UUID orderId);

  Optional<Order> getById(UUID id);
}
