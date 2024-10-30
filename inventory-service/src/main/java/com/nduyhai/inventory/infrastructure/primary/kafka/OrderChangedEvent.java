package com.nduyhai.inventory.infrastructure.primary.kafka;

import com.nduyhai.inventory.shared.enumeration.domain.OrderStatus;
import com.nduyhai.inventory.shared.money.domain.Money;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderChangedEvent {
  private UUID orderId;
  private UUID customerId;
  private List<LineItemEvent> items;
  private Money totalAmount;
  private OrderStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
