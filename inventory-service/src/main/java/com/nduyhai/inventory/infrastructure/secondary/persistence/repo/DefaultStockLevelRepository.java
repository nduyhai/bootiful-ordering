package com.nduyhai.inventory.infrastructure.secondary.persistence.repo;

import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.StockLevelRepository;
import com.nduyhai.inventory.domain.StockLevels;
import com.nduyhai.inventory.infrastructure.secondary.persistence.mapper.PersistenceMapper;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultStockLevelRepository implements StockLevelRepository {
  private final JpaStockLevelRepository jpaStockLevelRepository;
  private final PersistenceMapper persistenceMapper;

  @Override
  public Optional<StockLevel> findByProductIdAndLocationId(UUID productId, UUID locationId) {
    return this.jpaStockLevelRepository
        .findByProductIdAndLocationId(productId, locationId)
        .map(this.persistenceMapper::toDomain);
  }

  @Override
  public StockLevels findByProductId(UUID productId) {
    return new StockLevels(
        this.jpaStockLevelRepository.findByProductId(productId).stream()
            .map(this.persistenceMapper::toDomain)
            .toList());
  }
}