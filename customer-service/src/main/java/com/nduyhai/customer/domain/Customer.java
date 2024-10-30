package com.nduyhai.customer.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
  private UUID customerId;
  private String displayName;
}
