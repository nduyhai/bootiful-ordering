package com.nduyhai.ordering.infrastructure.primary;

import com.github.nduyhai.common.enumeration.OrderStatus;
import com.github.nduyhai.common.money.Money;
import com.nduyhai.ordering.domain.Order;
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

  public static RestOrder fromDomain(Order order) {
    final RestOrder orderEntity = new RestOrder();

    orderEntity.setOrderId(order.getOrderId());
    orderEntity.setCustomerId(order.getCustomerId());
    orderEntity.setTotalAmount(
        new Money(order.getTotalAmount().amount(), order.getTotalAmount().currency()));
    orderEntity.setStatus(order.getStatus());
    orderEntity.setCreatedAt(order.getCreatedAt());
    orderEntity.setUpdatedAt(order.getUpdatedAt());

    orderEntity.setItems(order.getItems().stream().map(RestLineItem::fromDomain).toList());

    return orderEntity;
  }
}
