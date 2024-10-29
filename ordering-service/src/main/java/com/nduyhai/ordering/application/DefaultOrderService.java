package com.nduyhai.ordering.application;

import com.nduyhai.ordering.shared.money.domain.Money;
import com.nduyhai.ordering.domain.Order;
import com.nduyhai.ordering.domain.OrderEventPublisher;
import com.nduyhai.ordering.domain.OrderRepository;
import com.nduyhai.ordering.shared.enumeration.domain.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
  private final OrderRepository orderRepository;
  private final OrderEventPublisher orderEventPublisher;

  @Transactional(readOnly = true)
  @Override
  public Optional<Order> getOrder(UUID orderId) {
    return this.orderRepository.getById(orderId);
  }

  @Transactional
  @Override
  public void cancel(UUID orderId) {
    this.orderRepository.cancelOder(orderId);
  }

  @Transactional
  @Override
  public Order createOrder(Order order) {

    order.setOrderId(UUID.randomUUID());
    order.setStatus(OrderStatus.PENDING);
    order.setCreatedAt(LocalDateTime.now());
    order.setUpdatedAt(order.getCreatedAt());
    order
        .getItems()
        .forEach(
            e ->
                e.setSubTotal(
                    new Money(
                        e.getPrice().amount().multiply(new BigDecimal(e.getQuantity())),
                        e.getPrice().currency())));

    final BigDecimal amount =
        order.getItems().stream()
            .map(e -> e.getSubTotal().amount())
            .reduce(BigDecimal::add)
            .orElse(new BigDecimal(0));

    order.setTotalAmount(new Money(amount, order.getItems().getFirst().getPrice().currency()));

    final Order savedOrder = this.orderRepository.createOrder(order);

    this.orderEventPublisher.publishEvent(savedOrder);

    return savedOrder;
  }
}
