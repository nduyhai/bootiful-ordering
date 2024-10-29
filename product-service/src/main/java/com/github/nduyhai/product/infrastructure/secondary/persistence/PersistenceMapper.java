package com.github.nduyhai.product.infrastructure.secondary.persistence;

import com.github.nduyhai.product.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {
  ProductEntity fromDomain(Product product);

  Product toDomain(ProductEntity productEntity);
}
