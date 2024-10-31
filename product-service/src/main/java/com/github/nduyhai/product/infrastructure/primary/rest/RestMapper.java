package com.nduyhai.product.infrastructure.primary.rest;

import com.nduyhai.product.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {
  RestProduct fromDomain(Product product);

  Product toDomain(RestProductToCreate productToCreate);
}
