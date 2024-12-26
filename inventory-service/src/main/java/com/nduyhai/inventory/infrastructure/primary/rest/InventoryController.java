package com.nduyhai.inventory.infrastructure.primary.rest;

import com.nduyhai.inventory.application.InventoryService;
import com.nduyhai.inventory.domain.StockLevel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
public class InventoryController {
  private final InventoryService inventoryService;

  private final RestMapper restMapper;

  @GetMapping("/available")
  public ResponseEntity<List<RestInventory>> getAvailableInventories(
      @RequestParam int page, @RequestParam int size) {

    List<StockLevel> stocks = this.inventoryService.getAvailable(PageRequest.of(page, size));

    return ResponseEntity.ok(this.restMapper.fromDomains(stocks));
  }

  @GetMapping("/{productId}")
  public ResponseEntity<RestInventory> getInventories(@PathVariable UUID productId) {
    Optional<StockLevel> stockLevel = this.inventoryService.getByProductId(productId);
    return stockLevel
        .map(value -> ResponseEntity.ok(this.restMapper.fromDomain(value)))
        .orElseGet(() -> ResponseEntity.badRequest().build());
  }
}
