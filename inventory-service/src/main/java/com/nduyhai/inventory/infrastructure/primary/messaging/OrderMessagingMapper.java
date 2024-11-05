package com.nduyhai.inventory.infrastructure.primary.messaging;

import com.nduyhai.inventory.domain.ReservedStock;
import com.nduyhai.inventory.domain.ReservedStocks;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMessagingMapper {

  ReservedStock toDomain(LineItemEvent lineItemEvent);

  ReservedStocks toDomain(OrderConfirmedEvent event);
}
