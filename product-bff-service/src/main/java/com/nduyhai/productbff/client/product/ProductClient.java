package com.nduyhai.productbff.client.product;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface ProductClient {

  @GetExchange("/products/{productId}")
  ProductRes getProduct(@PathVariable UUID productId);

  @GetExchange("/products/by-ids")
  List<ProductRes> getProducts(@RequestParam Collection<UUID> ids);
}
