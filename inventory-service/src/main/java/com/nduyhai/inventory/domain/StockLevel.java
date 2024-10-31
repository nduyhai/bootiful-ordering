package com.nduyhai.inventory.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockLevel {
  private UUID stockId;
  private UUID productId;
  private long totalQuantity;
  private long reservedQuantity;
  private long remainingQuantity;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
