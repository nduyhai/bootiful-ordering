package com.nduyhai.inventory.domain;

import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StockSelector {
  private final StockLevelRepository stockLevelRepository;

  public Optional<StockLevel> getByProductId(UUID productId) {
    return this.stockLevelRepository.findByProductId(productId);
  }
}
