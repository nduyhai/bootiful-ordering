package com.nduyhai.inventory.domain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;

public interface StockLevelRepository {

  Optional<StockLevel> findByProductId(UUID productId);

  List<StockLevel> getAvailable(PageRequest page);

  StockLevel save(StockLevel stockLevel);
}
