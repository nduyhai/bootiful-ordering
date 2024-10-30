package com.nduyhai.ordering.infrastructure.secondary.kafka;

import com.github.nduyhai.common.enumeration.OrderStatus;
import com.github.nduyhai.common.money.Money;
import com.nduyhai.ordering.domain.Order;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.event.types.DomainEvent;
import org.springframework.modulith.events.Externalized;

@Externalized(value = "OrderChangedEvent")
@Getter
@Setter
public class OrderChangedEvent implements DomainEvent {
  private UUID orderId;
  private UUID customerId;
  private List<LineItemEvent> items;
  private Money totalAmount;
  private OrderStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public static OrderChangedEvent fromDomain(Order order) {
    final OrderChangedEvent event = new OrderChangedEvent();
    event.orderId = order.getOrderId();
    event.customerId = order.getCustomerId();
    event.totalAmount = order.getTotalAmount();
    event.status = order.getStatus();
    event.items = order.getItems().stream().map(LineItemEvent::fromDomain).toList();
    event.createdAt = order.getCreatedAt();
    event.updatedAt = order.getUpdatedAt();
    return event;
  }
}
