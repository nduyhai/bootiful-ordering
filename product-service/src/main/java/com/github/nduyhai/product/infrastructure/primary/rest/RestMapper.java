package com.github.nduyhai.product.infrastructure.primary.rest;

import com.github.nduyhai.product.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {
  RestProduct fromDomain(Product product);

  Product toDomain(RestProductToCreate productToCreate);
}
