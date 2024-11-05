package com.nduyhai.productbff.client.product;

import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ProductClient {

  @GetExchange("/products/{productId}")
  ProductRes getProduct(@PathVariable UUID productId);
}
