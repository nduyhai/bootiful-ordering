package com.nduyhai.customer.domain;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
  Optional<Customer> getById(UUID customerId);
}
