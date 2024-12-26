package com.nduyhai.product.infrastructure.secondary.persistence;

import com.nduyhai.product.domain.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersistenceMapper {
  ProductEntity fromDomain(Product product);

  Product toDomain(ProductEntity productEntity);

  List<Product> toDomains(List<ProductEntity> productEntitys);
}
