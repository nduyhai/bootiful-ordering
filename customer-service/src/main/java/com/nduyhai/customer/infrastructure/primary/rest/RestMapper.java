package com.nduyhai.customer.infrastructure.primary.rest;

import com.nduyhai.customer.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestMapper {
  RestCustomer fromDomain(Customer customer);
}
