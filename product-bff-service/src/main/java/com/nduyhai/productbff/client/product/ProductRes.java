package com.nduyhai.productbff.client.product;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRes {
  private UUID productId;
  private String name;
  private String sku;
  private String description;
  private String category;
}
