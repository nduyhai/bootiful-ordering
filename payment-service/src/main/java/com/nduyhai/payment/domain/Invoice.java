package com.nduyhai.payment.domain;

import com.nduyhai.common.enumeration.InvoiceStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Invoice {
  private String invoiceCode;

  private String userId;

  private BigDecimal totalAmount;

  private BigDecimal paidAmount;

  private InvoiceStatus status;

  private String currency;

  private LocalDate dueDate;

  private LocalDateTime expiredAt;

  private String description;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private List<InvoiceItem> items;
}
