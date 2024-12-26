package com.nduyhai.productbff.service;

import com.nduyhai.productbff.dto.product.ProductInfo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
  Optional<ProductInfo> getById(UUID productId);

  List<ProductInfo> getProducts(int page, int size);
}
