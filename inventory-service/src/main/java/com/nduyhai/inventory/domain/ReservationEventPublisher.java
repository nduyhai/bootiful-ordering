package com.nduyhai.inventory.domain;

import java.util.List;

public interface ReservationEventPublisher {
  void onReserved(List<Reservation> reservations);
}
