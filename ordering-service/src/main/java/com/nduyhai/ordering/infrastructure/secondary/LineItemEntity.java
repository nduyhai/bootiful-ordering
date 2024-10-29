package com.nduyhai.ordering.infrastructure.secondary;

import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.domain.Money;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "line_items")
public class LineItemEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private UUID productId;
  private int quantity;
  @Embedded private MoneyEntity price;

  @AttributeOverride(name = "amount", column = @Column(name = "subAmount"))
  @AttributeOverride(name = "currency", column = @Column(name = "subCurrency"))
  @Embedded
  private MoneyEntity subTotal;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private OrderEntity orderEntity;

  public static LineItemEntity fromDomain(LineItem line) {
    LineItemEntity item = new LineItemEntity();
    item.setProductId(line.getProductId());
    item.setQuantity(line.getQuantity());
    item.setPrice(new MoneyEntity(line.getPrice().amount(), line.getPrice().currency()));
    item.setSubTotal(new MoneyEntity(line.getSubTotal().amount(), line.getSubTotal().currency()));

    return item;
  }

  @Transient
  public LineItem toDomain() {
    LineItem item = new LineItem();
    item.setProductId(this.productId);
    item.setQuantity(this.quantity);
    item.setPrice(new Money(this.price.getAmount(), this.price.getCurrency()));
    item.setSubTotal(new Money(this.subTotal.getAmount(), this.subTotal.getCurrency()));
    return item;
  }
}
