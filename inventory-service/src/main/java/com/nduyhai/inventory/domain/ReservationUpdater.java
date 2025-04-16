package com.nduyhai.inventory.domain;

import com.nduyhai.common.enumeration.ReservationStatus;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationUpdater {
  private final ReservationRepository reservationRepository;

  public List<Reservation> release(UUID orderId) {
    List<Reservation> reservations =
        this.reservationRepository.findByOrderIdAndStatus(orderId, ReservationStatus.PENDING);
    reservations.forEach(reservation -> reservation.setStatus(ReservationStatus.CANCELED));

    return this.reservationRepository.saveAll(reservations);
  }
}
