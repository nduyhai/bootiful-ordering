package com.nduyhai.ordering.infrastructure.primary;

import com.nduyhai.common.enumeration.OrderStatus;
import com.nduyhai.common.money.Money;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestOrder {
  private UUID orderId;
  private UUID customerId;
  private List<RestLineItem> items;
  private Money totalAmount;
  private OrderStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
