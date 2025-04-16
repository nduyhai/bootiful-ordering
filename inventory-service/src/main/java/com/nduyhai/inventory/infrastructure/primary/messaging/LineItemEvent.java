package com.nduyhai.inventory.infrastructure.primary.messaging;

import com.nduyhai.common.money.Money;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LineItemEvent {
  private UUID productId;
  private int quantity;
  private Money price;
  private Money subTotal;
}
