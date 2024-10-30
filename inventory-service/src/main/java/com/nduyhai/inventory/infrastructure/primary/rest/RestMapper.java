package com.nduyhai.inventory.infrastructure.primary.rest;

import com.nduyhai.inventory.domain.StockLevel;
import com.nduyhai.inventory.domain.StockLevels;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {

  RestInventory fromDomain(StockLevel stockLevel);

  RestInventories fromDomain(StockLevels stockLevels);
}
