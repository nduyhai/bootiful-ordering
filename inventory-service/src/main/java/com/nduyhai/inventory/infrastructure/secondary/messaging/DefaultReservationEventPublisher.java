package com.nduyhai.inventory.infrastructure.secondary.messaging;

import com.nduyhai.common.enumeration.ReservationStatus;
import com.nduyhai.inventory.domain.ReservationEventPublisher;
import com.nduyhai.inventory.domain.ReservationToCreate;
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
  public void publishEvent(ReservationToCreate req, ReservationStatus status) {

    ReservedInventoryEvent event = new ReservedInventoryEvent();

    event.setOrderId(req.orderId());
    event.setStatus(status);

    this.applicationEventPublisher.publishEvent(event);

    log.info("publish event {}", event);
  }
}
