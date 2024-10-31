package com.nduyhai.inventory.infrastructure.primary.rest;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestInventory {
  private UUID stockId;
  private UUID productId;
  private long totalQuantity;
  private long reservedQuantity;
  private long remainingQuantity;
  private LocalDateTime updatedAt;
}
