package com.nduyhai.customer.application;

import com.nduyhai.customer.domain.Customer;
import com.nduyhai.customer.domain.CustomerRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultCustomerService implements CustomerService {
  private final CustomerRepository customerRepository;

  @Transactional(readOnly = true)
  @Override
  public Optional<Customer> getById(UUID customerId) {
    return this.customerRepository.getById(customerId);
  }
}
