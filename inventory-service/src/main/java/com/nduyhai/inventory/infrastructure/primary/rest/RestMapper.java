package com.nduyhai.inventory.infrastructure.primary.rest;

import com.nduyhai.inventory.domain.StockLevel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {

  RestInventory fromDomain(StockLevel stockLevel);
}
