package com.nduyhai.productbff.dto.product;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductInfo {
  private UUID productId;
  private String name;
  private String sku;
  private String description;
  private String category;
  private InventoryInfo inventory;
}
