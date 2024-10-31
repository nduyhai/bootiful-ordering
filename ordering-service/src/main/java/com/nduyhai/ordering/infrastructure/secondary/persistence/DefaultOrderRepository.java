package com.nduyhai.ordering.infrastructure.secondary.persistence;

import com.github.nduyhai.common.enumeration.OrderStatus;
import com.nduyhai.ordering.domain.Order;
import com.nduyhai.ordering.domain.OrderRepository;
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
  private final PersistenceMapper persistenceMapper;

  @Override
  public Order createOrder(Order order) {
    OrderEntity orderEntity = this.persistenceMapper.fromDomain(order);

    orderEntity.getItems().forEach(line -> line.setOrderEntity(orderEntity));

    return this.persistenceMapper.toDomain(jpaOrderRepository.save(orderEntity));
  }

  @Override
  public Order cancelOder(UUID orderId) {
    OrderEntity orderEntity = this.jpaOrderRepository.getReferenceById(orderId);

    orderEntity.setStatus(OrderStatus.CANCELED);
    orderEntity.setUpdatedAt(LocalDateTime.now());

    return this.persistenceMapper.toDomain(this.jpaOrderRepository.save(orderEntity));
  }

  @Override
  public Optional<Order> getById(UUID id) {
    try {
      return Optional.of(
          this.persistenceMapper.toDomain(this.jpaOrderRepository.getReferenceById(id)));
    } catch (EntityNotFoundException e) {
      return Optional.empty();
    }
  }
}
