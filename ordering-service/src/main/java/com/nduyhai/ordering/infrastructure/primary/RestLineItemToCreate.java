package com.nduyhai.ordering.infrastructure.primary;

import com.nduyhai.common.money.Money;
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
}
