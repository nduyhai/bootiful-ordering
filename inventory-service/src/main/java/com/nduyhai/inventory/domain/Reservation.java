package com.nduyhai.inventory.domain;

import com.nduyhai.common.enumeration.ReservationStatus;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reservation {
  private UUID reservationId;
  private UUID productId;
  private UUID orderId;
  private long quantity;
  private ReservationStatus status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime expiredAt;
}
