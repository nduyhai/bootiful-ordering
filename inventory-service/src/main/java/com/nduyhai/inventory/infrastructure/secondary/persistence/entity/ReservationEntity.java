package com.nduyhai.inventory.infrastructure.secondary.persistence.entity;

import com.nduyhai.inventory.shared.enumeration.domain.ReservationStatus;
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

@Table(name = "reservations")
@Entity
@Getter
@Setter
public class ReservationEntity implements Serializable {
  @Id private UUID reservationId;
  private UUID productId;
  private UUID orderId;
  private long quantity;

  @Enumerated(value = EnumType.STRING)
  private ReservationStatus status;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime expiredAt;
}
