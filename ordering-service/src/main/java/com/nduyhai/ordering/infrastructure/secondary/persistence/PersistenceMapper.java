package com.nduyhai.ordering.infrastructure.secondary.persistence;

import com.github.nduyhai.common.money.Money;
import com.nduyhai.ordering.domain.LineItem;
import com.nduyhai.ordering.domain.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {

  OrderEntity fromDomain(Order order);

  MoneyEntity fromDomain(Money money);

  LineItemEntity fromDomain(LineItem lineItem);

  Order toDomain(OrderEntity orderEntity);

  Money toDomain(MoneyEntity moneyEntity);

  LineItem toDomain(LineItemEntity lineItemEntity);
}
