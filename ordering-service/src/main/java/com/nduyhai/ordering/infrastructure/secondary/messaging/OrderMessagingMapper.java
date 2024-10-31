package com.nduyhai.ordering.infrastructure.secondary.messaging;

import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.domain.Order;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMessagingMapper {
  OrderConfirmedEvent fromDomain(Order order);

  LineItemEvent fromDomain(LineItem lineItem);

  List<LineItemEvent> fromDomain(List<LineItem> lineItems);
}