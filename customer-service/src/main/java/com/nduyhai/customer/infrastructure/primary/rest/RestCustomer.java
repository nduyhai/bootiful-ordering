package com.nduyhai.customer.infrastructure.primary.rest;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestCustomer {
  private UUID customerId;
  private String displayName;
}
