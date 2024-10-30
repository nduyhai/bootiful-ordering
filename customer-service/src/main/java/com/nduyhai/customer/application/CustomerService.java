package com.nduyhai.customer.application;

import com.nduyhai.customer.domain.Customer;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
  Optional<Customer> getById(UUID customerId);
}
