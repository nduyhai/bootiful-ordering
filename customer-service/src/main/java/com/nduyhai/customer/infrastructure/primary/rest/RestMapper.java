package com.nduyhai.customer.infrastructure.primary.rest;

import com.nduyhai.customer.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestMapper {
  RestCustomer fromDomain(Customer customer);
}
