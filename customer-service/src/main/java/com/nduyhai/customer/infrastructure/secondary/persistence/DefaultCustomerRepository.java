package com.nduyhai.customer.infrastructure.secondary.persistence;

import com.nduyhai.customer.domain.Customer;
import com.nduyhai.customer.domain.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultCustomerRepository implements CustomerRepository {
  private final JpaCustomerRepository jpaCustomerRepository;
  private final PersistenceMapper persistenceMapper;

  @Override
  public Optional<Customer> getById(UUID customerId) {
    try {
      return Optional.of(
          this.persistenceMapper.toDomain(this.jpaCustomerRepository.getReferenceById(customerId)));
    } catch (EntityNotFoundException e) {
      return Optional.empty();
    }
  }
}
