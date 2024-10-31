package com.nduyhai.inventory.infrastructure.primary.messaging;

import com.nduyhai.inventory.domain.ReservedStock;
import com.nduyhai.inventory.domain.ReservedStocks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMessagingMapper {

  ReservedStock toDomain(LineItemEvent lineItemEvent);

  ReservedStocks toDomain(OrderConfirmedEvent event);
}
