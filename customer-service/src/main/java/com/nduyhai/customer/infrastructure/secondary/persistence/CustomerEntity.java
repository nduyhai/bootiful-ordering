package com.nduyhai.customer.infrastructure.secondary.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class CustomerEntity implements Serializable {
  @Id private UUID customerId;
  private String displayName;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
