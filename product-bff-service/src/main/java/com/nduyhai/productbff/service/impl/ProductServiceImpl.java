package com.nduyhai.productbff.service.impl;

import com.nduyhai.productbff.client.inventory.InventoryClient;
import com.nduyhai.productbff.client.inventory.InventoryRes;
import com.nduyhai.productbff.client.product.ProductClient;
import com.nduyhai.productbff.client.product.ProductRes;
import com.nduyhai.productbff.dto.product.InventoryInfo;
import com.nduyhai.productbff.dto.product.ProductInfo;
import com.nduyhai.productbff.mapper.InventoryMapper;
import com.nduyhai.productbff.mapper.ProductMapper;
import com.nduyhai.productbff.service.ProductService;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductClient productClient;
  private final InventoryClient inventoryClient;
  private final ProductMapper productMapper;
  private final InventoryMapper inventoryMapper;

  @Override
  public Optional<ProductInfo> getById(UUID productId) {
    ProductRes product = this.productClient.getProduct(productId);

    if (Objects.isNull(product)) {
      return Optional.empty();
    }
    InventoryRes inventory = this.inventoryClient.getProduct(productId);

    ProductInfo productInfo = productMapper.toProductInfo(product);

    InventoryInfo inventoryInfo = this.inventoryMapper.toInventory(inventory);
    if (Objects.nonNull(inventoryInfo)) {
      productInfo.setInventory(inventoryInfo);
    }

    return Optional.ofNullable(productInfo);
  }
}
