package com.nduyhai.inventory.application;

import com.nduyhai.inventory.domain.ReservationToCreate;
import com.nduyhai.inventory.domain.StockLevel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.PageRequest;

public interface InventoryService {
  Optional<StockLevel> getByProductId(UUID productId);

  void reserveStock(ReservationToCreate req);

  List<StockLevel> getAvailable(PageRequest page);
}
