package com.github.nduyhai.product.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private UUID productId;
  private String name;
  private String sku;
  private String description;
  private String category;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
