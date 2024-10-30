package com.nduyhai.inventory.application;

import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.StockLevelRepository;
import com.nduyhai.inventory.domain.StockLevels;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultInventoryService implements InventoryService {
  private final StockLevelRepository stockLevelRepository;

  @Override
  public StockLevels getByProductId(UUID productId) {
    return this.stockLevelRepository.findByProductId(productId);
  }

  @Override
  public Optional<StockLevel> getByProductLocation(UUID productId, UUID locationId) {
    return this.stockLevelRepository.findByProductIdAndLocationId(productId, locationId);
  }
}
