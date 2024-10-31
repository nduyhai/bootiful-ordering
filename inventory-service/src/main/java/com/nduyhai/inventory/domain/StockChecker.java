package com.nduyhai.inventory.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockChecker {
  private final StockLevelRepository stockLevelRepository;

  public boolean validateReservation(ReservationToCreate req) {

    for (ReservedStock item : req.items().getItems()) {
      StockLevel stock =
          this.stockLevelRepository
              .findByProductId(item.productId())
              .orElseThrow(StockNotFoundException::new);

      if (stock.getRemainingQuantity() < item.quantity()) {
        return false;
      }
    }
    return true;
  }
}
