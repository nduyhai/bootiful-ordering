package com.nduyhai.inventory.infrastructure.secondary.messaging;

import com.nduyhai.inventory.domain.Reservation;
import com.nduyhai.inventory.domain.ReservationEventPublisher;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultReservationEventPublisher implements ReservationEventPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  @Override
  public void onReserved(List<Reservation> reservations) {

    ReservedInventoryEvent event = new ReservedInventoryEvent();
    Optional<Reservation> reservation = reservations.stream().findFirst();
    if (reservation.isPresent()) {

      event.setOrderId(reservation.get().getOrderId());

      event.setReservedIds(reservations.stream().map(Reservation::getReservationId).toList());

      this.applicationEventPublisher.publishEvent(event);

      log.info("publish event {}", event);
    }
  }
}
