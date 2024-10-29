package com.github.nduyhai.product.application;

import com.github.nduyhai.product.domain.Product;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

  Product createProduct(Product product);

  Optional<Product> getProduct(UUID productId);
}
