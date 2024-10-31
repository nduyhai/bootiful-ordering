package com.nduyhai.ordering.infrastructure.primary;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestOrderToCreate {
  @NotNull private UUID customerId;
  @NotEmpty private List<RestLineItemToCreate> items;
}
