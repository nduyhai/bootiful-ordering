package com.nduyhai.ordering.infrastructure.secondary.messaging;

import com.nduyhai.common.money.Money;
import com.nduyhai.ordering.domain.LineItem;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItemEvent {
  private UUID productId;
  private int quantity;
  private Money price;
  private Money subTotal;

  public static LineItemEvent fromDomain(LineItem item) {
    final LineItemEvent event = new LineItemEvent();

    event.setProductId(item.getProductId());
    event.setQuantity(item.getQuantity());
    event.setPrice(item.getPrice());
    event.setSubTotal(item.getSubTotal());

    return event;
  }
}
