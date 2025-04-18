package com.nduyhai.payment.domain;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceItem {
  private UUID productId;

  private int quantity;

  private BigDecimal unitPrice;

  private BigDecimal subTotal;
}
