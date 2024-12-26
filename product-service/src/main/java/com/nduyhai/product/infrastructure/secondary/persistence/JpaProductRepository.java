package com.nduyhai.product.infrastructure.secondary.persistence;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {
  List<ProductEntity> findByProductIdIn(Collection<UUID> ids);
}
