package com.nduyhai.productbff.controller;

import com.nduyhai.productbff.dto.product.ProductInfo;
import com.nduyhai.productbff.service.ProductService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductBffController {
  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductInfo>> getProducts(int page, int size) {
    return ResponseEntity.ok(this.productService.getProducts(page, size));
  }

  @GetMapping("/{productId}")
  public ResponseEntity<ProductInfo> getProductById(@PathVariable UUID productId) {
    return this.productService
        .getById(productId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());
  }
}
