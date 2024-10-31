package com.nduyhai.inventory.domain;

import java.util.Optional;
import java.util.UUID;

public interface StockLevelRepository {

  Optional<StockLevel> findByProductId(UUID productId);

  StockLevel save(StockLevel stockLevel);
}
