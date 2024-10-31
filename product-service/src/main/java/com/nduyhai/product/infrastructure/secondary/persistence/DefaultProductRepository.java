package com.nduyhai.product.infrastructure.secondary.persistence;

import com.nduyhai.product.domain.Product;
import com.nduyhai.product.domain.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultProductRepository implements ProductRepository {
  private final JpaProductRepository jpaProductRepository;
  private final PersistenceMapper persistenceMapper;

  @Override
  public Optional<Product> getById(UUID productId) {
    try {
      return Optional.of(
          this.persistenceMapper.toDomain(this.jpaProductRepository.getReferenceById(productId)));
    } catch (EntityNotFoundException e) {
      return Optional.empty();
    }
  }

  @Override
  public Product create(Product product) {
    ProductEntity entity = this.jpaProductRepository.save(persistenceMapper.fromDomain(product));
    return this.persistenceMapper.toDomain(entity);
  }
}
