package com.nduyhai.inventory.domain;

import java.util.List;

public interface ReservationRepository {
  Reservation save(Reservation reservation);

  List<Reservation> saveAll(List<Reservation> reservations);
}
