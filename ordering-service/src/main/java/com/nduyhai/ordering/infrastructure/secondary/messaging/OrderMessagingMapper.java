package com.nduyhai.ordering.infrastructure.secondary.messaging;

import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.domain.Order;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMessagingMapper {
  OrderChangedEvent fromDomain(Order order);

  LineItemEvent fromDomain(LineItem lineItem);

  List<LineItemEvent> fromDomain(List<LineItem> lineItems);
}
