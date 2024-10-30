package com.nduyhai.customer.infrastructure.primary.rest;

import com.nduyhai.customer.application.CustomerService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService customerService;
  private final RestMapper restMapper;

  @GetMapping("/{customerId}")
  public ResponseEntity<RestCustomer> getCustomer(@PathVariable UUID customerId) {
    return this.customerService
        .getById(customerId)
        .map(this.restMapper::fromDomain)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.badRequest().build());
  }
}
