package com.nduyhai.ordering.infrastructure.primary;

import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.domain.Money;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestLineItem {
  private UUID productId;
  private int quantity;
  private Money price;
  private Money subTotal;

  public static RestLineItem fromDomain(LineItem line) {
    RestLineItem item = new RestLineItem();
    item.setProductId(line.getProductId());
    item.setQuantity(line.getQuantity());
    item.setPrice(line.getPrice());
    item.setSubTotal(line.getSubTotal());
    return item;
  }
}
