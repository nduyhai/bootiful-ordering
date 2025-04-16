package com.nduyhai.inventory.domain;

import com.nduyhai.common.enumeration.ReservationStatus;
import java.util.List;
import java.util.UUID;

public interface ReservationRepository {
  Reservation save(Reservation reservation);

  List<Reservation> saveAll(List<Reservation> reservations);

  List<Reservation> findByOrderIdAndStatus(UUID orderId, ReservationStatus status);
}
