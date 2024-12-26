package com.nduyhai.inventory.infrastructure.primary.rest;

import com.nduyhai.inventory.domain.StockLevel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestMapper {

  RestInventory fromDomain(StockLevel stockLevel);

  List<RestInventory> fromDomains(List<StockLevel> stockLevels);
}
