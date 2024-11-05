package com.nduyhai.productbff.mapper;

import com.nduyhai.productbff.client.product.ProductRes;
import com.nduyhai.productbff.dto.product.ProductInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
  ProductInfo toProductInfo(ProductRes productRes);
}
