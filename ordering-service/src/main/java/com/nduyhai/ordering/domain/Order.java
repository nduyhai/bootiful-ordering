package com.nduyhai.ordering.domain;

import com.nduyhai.ordering.shared.enumeration.domain.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
  private UUID orderId;
  private UUID customerId;
  private List<LineItem> items;
  private Money totalAmount;
  private OrderStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
