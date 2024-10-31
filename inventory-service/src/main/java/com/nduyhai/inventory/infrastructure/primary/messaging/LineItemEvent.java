package com.nduyhai.inventory.infrastructure.primary.messaging;

import com.nduyhai.common.money.Money;
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
}
