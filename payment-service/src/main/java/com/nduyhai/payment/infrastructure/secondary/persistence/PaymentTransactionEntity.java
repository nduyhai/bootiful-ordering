package com.nduyhai.payment.infrastructure.secondary.persistence;

import com.nduyhai.common.enumeration.PaymentMethod;
import com.nduyhai.common.enumeration.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "payment_transaction")
public class PaymentTransactionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "payment_code", unique = true, nullable = false)
  private String paymentCode;

  @ManyToOne
  @JoinColumn(name = "invoice_id")
  private InvoiceEntity invoice;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  @Column(name = "payment_method")
  private PaymentMethod paymentMethod;

  @Enumerated(EnumType.STRING)
  @Column(name = "status")
  private PaymentStatus status;

  @Column(name = "provider_transaction_id")
  private String providerTransactionId;

  @Column(name = "provider_name")
  private String providerName; // e.g. "VNPay", "Momo"

  @Column(name = "callback_received")
  private Boolean callbackReceived = false;

  @Column(name = "raw_request", columnDefinition = "TEXT")
  private String rawRequest;

  @Column(name = "raw_response", columnDefinition = "TEXT")
  private String rawResponse;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
