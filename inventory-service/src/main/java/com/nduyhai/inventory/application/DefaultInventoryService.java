package com.nduyhai.inventory.application;

import com.nduyhai.common.enumeration.ReservationStatus;
import com.nduyhai.inventory.domain.ReservationCreator;
import com.nduyhai.inventory.domain.ReservationEventPublisher;
import com.nduyhai.inventory.domain.ReservationToCreate;
import com.nduyhai.inventory.domain.StockChecker;
import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.StockSelector;
import com.nduyhai.inventory.domain.StockUpdater;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultInventoryService implements InventoryService {
  private final StockSelector stockSelector;
  private final StockChecker stockChecker;
  private final StockUpdater stockUpdater;
  private final ReservationCreator reservationCreator;
  private final ReservationEventPublisher reservationEventPublisher;

  @Transactional(readOnly = true)
  @Override
  public Optional<StockLevel> getByProductId(UUID productId) {
    return this.stockSelector.getByProductId(productId);
  }

  @Transactional
  @Override
  public void reserveStock(ReservationToCreate req) {
    boolean valid = this.stockChecker.validateReservation(req);
    if (valid) {

      this.stockUpdater.reserve(req);

      this.reservationCreator.create(req);

      this.reservationEventPublisher.publishEvent(req, ReservationStatus.FAILED);

    } else {
      this.reservationEventPublisher.publishEvent(req, ReservationStatus.PENDING);
    }
  }

  @Override
  public List<StockLevel> getAvailable(PageRequest page) {
    return this.stockSelector.getAvailable(page);
  }
}
