package com.nduyhai.inventory.infrastructure.secondary.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Table(name = "stock_levels")
@Entity
@Getter
@Setter
public class StockLevelEntity implements Serializable {
  @Id private UUID stockId;
  private UUID productId;
  private long totalQuantity;
  private long reservedQuantity;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
