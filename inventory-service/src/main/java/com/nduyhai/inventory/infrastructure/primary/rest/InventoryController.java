package com.nduyhai.inventory.infrastructure.primary.rest;

import com.nduyhai.inventory.application.InventoryService;
import com.nduyhai.inventory.domain.StockLevel;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventories")
@RequiredArgsConstructor
public class InventoryController {
  private final InventoryService inventoryService;

  private final RestMapper restMapper;

  @GetMapping("/{productId}")
  public ResponseEntity<RestInventories> getInventories(@PathVariable UUID productId) {
    return ResponseEntity.ok(
        this.restMapper.fromDomain(this.inventoryService.getByProductId(productId)));
  }

  @GetMapping("/{productId}/{locationId}")
  public ResponseEntity<RestInventory> getInventory(
      @PathVariable UUID productId, @PathVariable UUID locationId) {
    Optional<StockLevel> stockLevel =
        this.inventoryService.getByProductLocation(productId, locationId);

    return stockLevel
        .map(value -> ResponseEntity.ok(this.restMapper.fromDomain(value)))
        .orElseGet(() -> ResponseEntity.badRequest().build());
  }
}
