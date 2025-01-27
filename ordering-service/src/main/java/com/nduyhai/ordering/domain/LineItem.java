package com.nduyhai.ordering.domain;

import com.nduyhai.ordering.shared.money.domain.Money;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem {
  private UUID productId;
  private int quantity;
  private Money price;
  private Money subTotal;

}
