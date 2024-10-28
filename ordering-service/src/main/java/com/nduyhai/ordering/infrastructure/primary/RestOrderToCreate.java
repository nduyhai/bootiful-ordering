package com.nduyhai.ordering.infrastructure.primary;

import com.nduyhai.ordering.domain.Order;
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

  public Order toDomain() {
    final Order orderEntity = new Order();
    orderEntity.setCustomerId(customerId);
    orderEntity.setItems(items.stream().map(RestLineItemToCreate::toDomain).toList());
    return orderEntity;
  }
}
