package com.nduyhai.inventory.infrastructure.secondary.persistence.repo;

import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.StockLevelRepository;
import com.nduyhai.inventory.infrastructure.secondary.persistence.entity.StockLevelEntity;
import com.nduyhai.inventory.infrastructure.secondary.persistence.mapper.StockPersistenceMapper;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultStockLevelRepository implements StockLevelRepository {
  private final JpaStockLevelRepository jpaStockLevelRepository;
  private final StockPersistenceMapper stockPersistenceMapper;

  @Override
  public Optional<StockLevel> findByProductId(UUID productId) {
    return this.jpaStockLevelRepository
        .findByProductId(productId)
        .map(this.stockPersistenceMapper::toDomain);
  }

  @Override
  public List<StockLevel> getAvailable(PageRequest page) {
    List<StockLevelEntity> stocks =
        this.jpaStockLevelRepository.findAllByTotalQuantityGreaterThan(0, page);
    return this.stockPersistenceMapper.toDomains(stocks);
  }

  @Override
  public StockLevel save(StockLevel stockLevel) {
    StockLevelEntity saved =
        this.jpaStockLevelRepository.save(this.stockPersistenceMapper.fromDomain(stockLevel));

    return this.stockPersistenceMapper.toDomain(saved);
  }
}
