package com.nduyhai.product.infrastructure.primary.rest;

import com.nduyhai.product.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestMapper {
  RestProduct fromDomain(Product product);

  Product toDomain(RestProductToCreate productToCreate);
}
