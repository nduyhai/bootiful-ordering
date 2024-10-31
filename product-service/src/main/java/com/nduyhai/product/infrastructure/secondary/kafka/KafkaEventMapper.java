package com.nduyhai.product.infrastructure.secondary.kafka;

import com.nduyhai.product.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KafkaEventMapper {
  ProductChangedEvent fromDomain(Product product);
}
