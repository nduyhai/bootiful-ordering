package com.nduyhai.customer.infrastructure.secondary.persistence;

import com.nduyhai.customer.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {
  Customer toDomain(CustomerEntity customerEntity);

  CustomerEntity fromDomain(Customer customer);
}
