package com.nduyhai.ordering.infrastructure.primary;

import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.shared.money.domain.Money;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestLineItemToCreate {

  @NotNull private UUID productId;
  private int quantity;
  @NotNull private Money price;

  public LineItem toDomain() {
    LineItem item = new LineItem();
    item.setProductId(productId);
    item.setQuantity(quantity);
    item.setPrice(price);
    return item;
  }
}
