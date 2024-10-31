package com.nduyhai.inventory.domain;

import com.nduyhai.common.enumeration.TransactionType;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
  private UUID transactionId;
  private UUID productId;
  private UUID orderId;

  private TransactionType type;

  private long quantity;
  private long balanceAfter;
  private LocalDateTime createdAt;
}
