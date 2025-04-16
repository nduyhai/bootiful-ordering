package com.nduyhai.ordering.infrastructure.primary.messaging;

import com.nduyhai.common.enumeration.ReservationStatus;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReservedInventoryEvent {
  private UUID orderId;
  private ReservationStatus status;
}
