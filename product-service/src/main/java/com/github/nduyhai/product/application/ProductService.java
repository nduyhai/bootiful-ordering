package com.nduyhai.product.application;

import com.nduyhai.product.domain.Product;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

  Product createProduct(Product product);

  Optional<Product> getProduct(UUID productId);
}
