package com.github.nduyhai.product.infrastructure.primary.rest;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestProduct {
  private UUID productId;
  private String name;
  private String sku;
  private String description;
  private String category;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
