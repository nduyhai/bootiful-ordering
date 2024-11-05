package com.nduyhai.customer.infrastructure.secondary.persistence;

import com.nduyhai.customer.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersistenceMapper {
  Customer toDomain(CustomerEntity customerEntity);

  CustomerEntity fromDomain(Customer customer);
}
