package com.nduyhai.inventory.application;

import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.StockLevels;
import java.util.Optional;
import java.util.UUID;

public interface InventoryService {
  StockLevels getByProductId(UUID productId);

  Optional<StockLevel> getByProductLocation(UUID productId, UUID locationId);
}
