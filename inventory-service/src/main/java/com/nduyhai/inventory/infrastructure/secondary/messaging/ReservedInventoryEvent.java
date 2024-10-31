package com.nduyhai.inventory.infrastructure.secondary.messaging;

import com.nduyhai.common.enumeration.ReservationStatus;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jmolecules.event.types.DomainEvent;
import org.springframework.modulith.events.Externalized;

@Externalized(value = "ReservedInventoryEvent")
@Getter
@Setter
@ToString
public class ReservedInventoryEvent implements DomainEvent {
  private UUID orderId;
  private ReservationStatus status;
}
