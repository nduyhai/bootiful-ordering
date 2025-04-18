package com.nduyhai.payment.domain;

import com.nduyhai.common.enumeration.PaymentMethod;
import com.nduyhai.common.enumeration.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentTransaction {
  private String paymentCode;

  private String invoiceId;

  private String userId;

  private BigDecimal amount;

  private PaymentMethod paymentMethod;

  private PaymentStatus status;

  private String providerTransactionId;

  private String providerName;

  private Boolean callbackReceived;

  private String rawRequest;

  private String rawResponse;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}
