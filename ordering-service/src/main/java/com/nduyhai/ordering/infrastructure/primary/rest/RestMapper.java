package com.nduyhai.ordering.infrastructure.primary.rest;

import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.domain.Order;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestMapper {
  RestOrder fromDomain(Order order);

  Order toDomain(RestOrderToCreate req);

  LineItem toDomain(RestLineItemToCreate reqLine);

  List<LineItem> toDomain(List<RestLineItemToCreate> reqLines);
}
