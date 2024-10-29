package com.github.nduyhai.product.infrastructure.secondary.kafka;

import com.github.nduyhai.product.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KafkaEventMapper {
  ProductChangedEvent fromDomain(Product product);
}
