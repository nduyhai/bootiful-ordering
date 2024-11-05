package com.nduyhai.productbff.client.inventory;

import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {
  @GetExchange("/inventories/{productId}")
  InventoryRes getProduct(@PathVariable UUID productId);
}
