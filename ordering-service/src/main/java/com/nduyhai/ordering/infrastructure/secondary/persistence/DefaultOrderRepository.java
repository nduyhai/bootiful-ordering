package com.nduyhai.ordering.infrastructure.secondary.persistence;

import com.nduyhai.ordering.domain.Order;
import com.nduyhai.ordering.domain.OrderRepository;
import com.nduyhai.ordering.shared.enumeration.domain.OrderStatus;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultOrderRepository implements OrderRepository {
  private final JpaOrderRepository jpaOrderRepository;

  @Override
  public Order createOrder(Order order) {
    return this.jpaOrderRepository.save(OrderEntity.fromDomain(order)).toDomain();
  }

  @Override
  public Order cancelOder(UUID orderId) {
    OrderEntity orderEntity = this.jpaOrderRepository.getReferenceById(orderId);

    orderEntity.setStatus(OrderStatus.CANCELED);
    orderEntity.setUpdatedAt(LocalDateTime.now());

    return this.jpaOrderRepository.save(orderEntity).toDomain();
  }

  @Override
  public Optional<Order> getById(UUID id) {
    try {
      return Optional.of(this.jpaOrderRepository.getReferenceById(id).toDomain());
    } catch (EntityNotFoundException e) {
      return Optional.empty();
    }
  }
}
