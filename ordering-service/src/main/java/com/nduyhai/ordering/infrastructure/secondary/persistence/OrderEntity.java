package com.nduyhai.ordering.infrastructure.secondary.persistence;

import com.nduyhai.ordering.shared.money.domain.Money;
import com.nduyhai.ordering.domain.Order;
import com.nduyhai.ordering.shared.enumeration.domain.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
  @Id private UUID orderId;
  private UUID customerId;
  @Embedded private MoneyEntity totalAmount;
  private OrderStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<LineItemEntity> items;

  public static OrderEntity fromDomain(Order order) {
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setOrderId(order.getOrderId());
    orderEntity.setCustomerId(order.getCustomerId());
    orderEntity.setTotalAmount(
        new MoneyEntity(order.getTotalAmount().amount(), order.getTotalAmount().currency()));
    orderEntity.setStatus(order.getStatus());
    orderEntity.setCreatedAt(order.getCreatedAt());
    orderEntity.setUpdatedAt(order.getUpdatedAt());

    orderEntity.setItems(order.getItems().stream().map(LineItemEntity::fromDomain).toList());
    orderEntity.getItems().forEach(item -> item.setOrderEntity(orderEntity));

    return orderEntity;
  }

  @Transient
  public Order toDomain() {
    Order orderEntity = new Order();

    orderEntity.setOrderId(this.orderId);
    orderEntity.setCustomerId(this.customerId);
    orderEntity.setTotalAmount(
        new Money(this.totalAmount.getAmount(), this.totalAmount.getCurrency()));
    orderEntity.setStatus(this.status);
    orderEntity.setCreatedAt(this.createdAt);
    orderEntity.setUpdatedAt(this.updatedAt);
    orderEntity.setItems(this.getItems().stream().map(LineItemEntity::toDomain).toList());

    return orderEntity;
  }
}
