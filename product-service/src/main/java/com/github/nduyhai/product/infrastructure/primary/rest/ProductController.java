package com.github.nduyhai.product.infrastructure.primary.rest;

import com.github.nduyhai.product.application.ProductService;
import com.github.nduyhai.product.domain.Product;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;
  private final RestMapper restMapper;

  @PostMapping
  public ResponseEntity<RestProduct> createProduct(@RequestBody RestProductToCreate req) {
    Product product = this.productService.createProduct(this.restMapper.toDomain(req));
    return ResponseEntity.ok(this.restMapper.fromDomain(product));
  }

  @GetMapping("/{productId}")
  public ResponseEntity<RestProduct> getProduct(@PathVariable UUID productId) {
    Optional<Product> product = this.productService.getProduct(productId);
    return product
        .map(value -> ResponseEntity.ok(this.restMapper.fromDomain(value)))
        .orElseGet(() -> ResponseEntity.badRequest().build());
  }
}
