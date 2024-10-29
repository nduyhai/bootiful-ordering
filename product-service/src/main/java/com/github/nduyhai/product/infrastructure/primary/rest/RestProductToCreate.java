package com.github.nduyhai.product.infrastructure.primary.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestProductToCreate {
  private String name;
  private String sku;
  private String description;
  private String category;
}
