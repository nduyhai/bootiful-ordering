package com.github.nduyhai.product.infrastructure.secondary.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Table(name = "products")
@Entity
@Getter
@Setter
public class ProductEntity implements Serializable {
  @Id private UUID productId;
  private String name;
  private String sku;
  private String description;
  private String category;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
