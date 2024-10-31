package com.nduyhai.inventory.domain;

import com.nduyhai.common.enumeration.ReservationStatus;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationCreator {
  private final ReservationRepository reservationRepository;

  public List<Reservation> create(ReservationToCreate req) {
    final LocalDateTime currentTime = LocalDateTime.now();

    ReservedStocks items = req.items();
    Collection<ReservedStock> stocks = items.getItems();

    final List<Reservation> reservations =
        stocks.stream()
            .map(
                reservedStock -> {
                  Reservation reservation = new Reservation();

                  reservation.setReservationId(UUID.randomUUID());
                  reservation.setProductId(reservedStock.productId());
                  reservation.setOrderId(req.orderId());
                  reservation.setQuantity(reservedStock.quantity());
                  reservation.setStatus(ReservationStatus.PENDING);
                  reservation.setCreatedAt(currentTime);
                  reservation.setUpdatedAt(currentTime);
                  reservation.setExpiredAt(currentTime);

                  return reservation;
                })
            .toList();

    return this.reservationRepository.saveAll(reservations);
  }
}
