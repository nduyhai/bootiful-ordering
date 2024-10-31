package com.nduyhai.inventory.domain;

import com.nduyhai.common.enumeration.ReservationStatus;

public interface ReservationEventPublisher {

  void publishEvent(ReservationToCreate req, ReservationStatus status);
}
