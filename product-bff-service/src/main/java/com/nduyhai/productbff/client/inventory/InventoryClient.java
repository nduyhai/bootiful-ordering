package com.nduyhai.productbff.client.inventory;

import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {
  @GetExchange("/inventories/{productId}")
  InventoryRes getProduct(@PathVariable UUID productId);

  @GetExchange("/inventories/available")
  List<InventoryRes> getAvailableProducts(@RequestParam int page, @RequestParam int size);
}
