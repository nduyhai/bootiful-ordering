package com.nduyhai.productbff.client.inventory;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryRes {
  private UUID productId;
  private long remainingQuantity;
}
