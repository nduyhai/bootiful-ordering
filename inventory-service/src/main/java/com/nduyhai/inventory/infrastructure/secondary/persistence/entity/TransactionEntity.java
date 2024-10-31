package com.nduyhai.inventory.infrastructure.secondary.persistence.entity;

import com.nduyhai.common.enumeration.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Table(name = "transactions")
@Entity
@Getter
@Setter
public class TransactionEntity implements Serializable {
  @Id private UUID transactionId;
  private UUID productId;
  private UUID orderId;

  @Enumerated(value = EnumType.STRING)
  private TransactionType type;

  private long quantity;
  private long balanceAfter;
  private LocalDateTime createdAt;
}
