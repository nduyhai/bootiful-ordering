package com.nduyhai.product.infrastructure.secondary.kafka;

import com.nduyhai.product.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface KafkaEventMapper {
  ProductChangedEvent fromDomain(Product product);
}
