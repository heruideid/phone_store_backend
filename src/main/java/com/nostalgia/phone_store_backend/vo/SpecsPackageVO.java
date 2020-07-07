package com.nostalgia.phone_store_backend.vo;

import lombok.Data;

import java.util.Map;

@Data
public class SpecsPackageVO {
    Map<String,String> goods;
    SkuVO sku;
}
