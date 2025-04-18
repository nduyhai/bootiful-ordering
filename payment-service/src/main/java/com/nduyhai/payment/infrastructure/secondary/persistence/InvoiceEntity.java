package com.nduyhai.payment.infrastructure.secondary.persistence;

import com.nduyhai.common.enumeration.InvoiceStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "invoice")
public class InvoiceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "invoice_code", unique = true, nullable = false)
  private String invoiceCode;

  @Column(name = "user_id", nullable = false)
  private String userId;

  @Column(name = "total_amount", nullable = false)
  private BigDecimal totalAmount;

  @Column(name = "paid_amount", nullable = false)
  private BigDecimal paidAmount;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private InvoiceStatus status;

  @Column(name = "currency", length = 3)
  private String currency;

  @Column(name = "due_date")
  private LocalDate dueDate;

  @Column(name = "expired_at")
  private LocalDateTime expiredAt;

  @Column(name = "description", length = 500)
  private String description;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<PaymentTransactionEntity> payments = new ArrayList<>();

  @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<InvoiceItemEntity> items = new ArrayList<>();
}
