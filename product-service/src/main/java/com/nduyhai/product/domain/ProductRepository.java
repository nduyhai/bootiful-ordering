package com.nduyhai.product.domain;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
  Optional<Product> getById(UUID productId);

  List<Product> getProducts(Collection<UUID> productIds);

  Product create(Product product);
}
