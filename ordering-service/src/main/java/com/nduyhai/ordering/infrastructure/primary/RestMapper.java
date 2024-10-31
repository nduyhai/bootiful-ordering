package com.nduyhai.ordering.infrastructure.primary;

import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.domain.Order;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {
  RestOrder fromDomain(Order order);

  Order toDomain(RestOrderToCreate req);

  LineItem toDomain(RestLineItemToCreate reqLine);

  List<LineItem> toDomain(List<RestLineItemToCreate> reqLines);
}
