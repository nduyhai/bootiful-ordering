package com.nduyhai.product.domain;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
  Optional<Product> getById(UUID productId);

  Product create(Product product);
}
