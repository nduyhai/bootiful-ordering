package com.nduyhai.inventory.infrastructure.secondary.persistence.repo;

import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.StockLevelEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStockLevelRepository extends JpaRepository<StockLevelEntity, UUID> {
  Optional<StockLevelEntity> findByProductId(UUID productId);
}
