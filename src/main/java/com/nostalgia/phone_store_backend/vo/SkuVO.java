package com.nostalgia.phone_store_backend.vo;

import lombok.Data;

import java.util.List;

@Data
public class SkuVO {
    List<TreeVO> tree;
    List<SpecsStockAndPriceVO> list;
    String price;
    Integer stock_num;
    Boolean none_sku=false;
    Boolean hide_stock=false;
}
