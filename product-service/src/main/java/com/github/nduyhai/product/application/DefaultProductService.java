package com.nduyhai.product.application;

import com.nduyhai.product.domain.Product;
import com.nduyhai.product.domain.ProductEventPublisher;
import com.nduyhai.product.domain.ProductRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
  private final ProductRepository productRepository;
  private final ProductEventPublisher productEventPublisher;

  @Transactional
  @Override
  public Product createProduct(Product product) {
    product.setProductId(UUID.randomUUID());
    product.setCreatedAt(LocalDateTime.now());
    product.setUpdatedAt(product.getCreatedAt());
    Product savedProduct = this.productRepository.create(product);

    this.productEventPublisher.publishEvent(savedProduct);
    return savedProduct;
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<Product> getProduct(UUID productId) {
    return this.productRepository.getById(productId);
  }
}
