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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
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

  @Override
  public List<ProductInfo> getProducts(int page, int size) {
    List<InventoryRes> inventories = this.inventoryClient.getAvailableProducts(page, size);

    Map<UUID, InventoryRes> mapInventories =
        inventories.stream().collect(Collectors.toMap(InventoryRes::getProductId, e -> e));
    if (mapInventories.isEmpty()) {
      return List.of();
    }
    List<ProductRes> products = this.productClient.getProducts(mapInventories.keySet());

    return products.stream()
        .map(
            product -> {
              ProductInfo productInfo = productMapper.toProductInfo(product);
              InventoryRes inventory = mapInventories.get(product.getProductId());
              if (Objects.nonNull(inventory)) {
                InventoryInfo inventoryInfo = this.inventoryMapper.toInventory(inventory);
                if (Objects.nonNull(inventoryInfo)) {
                  productInfo.setInventory(inventoryInfo);
                }
              }
              return productInfo;
            })
        .toList();
  }
}
