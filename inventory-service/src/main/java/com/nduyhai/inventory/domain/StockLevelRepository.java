package com.nduyhai.inventory.domain;

import java.util.Optional;
import java.util.UUID;

public interface StockLevelRepository {
  Optional<StockLevel> findByProductIdAndLocationId(UUID productId, UUID locationId);

  StockLevels findByProductId(UUID productId);
}
