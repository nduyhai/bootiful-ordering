package com.nduyhai.inventory.application;

import com.nduyhai.common.enumeration.ReservationStatus;
import com.nduyhai.inventory.domain.Reservation;
import com.nduyhai.inventory.domain.ReservationEventPublisher;
import com.nduyhai.inventory.domain.ReservationRepository;
import com.nduyhai.inventory.domain.ReservationToCreate;
import com.nduyhai.inventory.domain.ReservedStock;
import com.nduyhai.inventory.domain.ReservedStocks;
import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.StockLevelRepository;
import com.nduyhai.inventory.domain.StockLevels;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultInventoryService implements InventoryService {
  private final StockLevelRepository stockLevelRepository;
  private final ReservationRepository reservationRepository;
  private final ReservationEventPublisher reservationEventPublisher;

  @Transactional(readOnly = true)
  @Override
  public StockLevels getByProductId(UUID productId) {
    return this.stockLevelRepository.findByProductId(productId);
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<StockLevel> getByProductLocation(UUID productId, UUID locationId) {
    return this.stockLevelRepository.findByProductIdAndLocationId(productId, locationId);
  }

  @Transactional
  @Override
  public void reserveStock(ReservationToCreate req) {
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

    final List<Reservation> savedReservations = this.reservationRepository.saveAll(reservations);

    this.reservationEventPublisher.onReserved(savedReservations);
  }
}
