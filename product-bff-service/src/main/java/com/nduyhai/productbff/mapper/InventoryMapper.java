package com.nduyhai.productbff.mapper;

import com.nduyhai.productbff.client.inventory.InventoryRes;
import com.nduyhai.productbff.dto.product.InventoryInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryMapper {
  InventoryInfo toInventory(InventoryRes inventoryRes);
}
