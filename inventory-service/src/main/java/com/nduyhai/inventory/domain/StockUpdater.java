package com.nduyhai.inventory.domain;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockUpdater {
  private final StockLevelRepository stockLevelRepository;

  public void reserve(ReservationToCreate req) {
    for (ReservedStock item : req.items().getItems()) {
      StockLevel stock =
          this.stockLevelRepository
              .findByProductId(item.productId())
              .orElseThrow(StockNotFoundException::new);

      stock.setTotalQuantity(stock.getTotalQuantity() - item.quantity());
      stock.setReservedQuantity(stock.getReservedQuantity() + item.quantity());
      stock.setRemainingQuantity(stock.getTotalQuantity() - stock.getReservedQuantity());

      this.stockLevelRepository.save(stock);
    }
  }

  public void release(List<ReservedStock> stocks) {
    for (ReservedStock item : stocks) {
      StockLevel stock =
          this.stockLevelRepository
              .findByProductId(item.productId())
              .orElseThrow(StockNotFoundException::new);

      stock.setTotalQuantity(stock.getTotalQuantity() + item.quantity());
      stock.setReservedQuantity(stock.getReservedQuantity() - item.quantity());
      stock.setRemainingQuantity(stock.getTotalQuantity() + stock.getReservedQuantity());

      this.stockLevelRepository.save(stock);
    }
  }
}
