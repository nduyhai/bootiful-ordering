package com.nduyhai.inventory.infrastructure.primary.rest;

import com.nduyhai.inventory.domain.StockLevel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestMapper {

  RestInventory fromDomain(StockLevel stockLevel);
}
