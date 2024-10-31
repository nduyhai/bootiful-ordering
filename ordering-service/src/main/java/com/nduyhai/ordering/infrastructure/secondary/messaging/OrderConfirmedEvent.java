package com.nduyhai.ordering.infrastructure.secondary.messaging;

import com.nduyhai.common.enumeration.OrderStatus;
import com.nduyhai.common.money.Money;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.jmolecules.event.types.DomainEvent;
import org.springframework.modulith.events.Externalized;

@Externalized(value = "OrderConfirmedEvent")
@Getter
@Setter
public class OrderConfirmedEvent implements DomainEvent {
  private UUID orderId;
  private UUID customerId;
  private List<LineItemEvent> items;
  private Money totalAmount;
  private OrderStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
