package com.nostalgia.phone_store_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SpecsStockAndPriceVO {
    @JsonProperty("s1")
    Integer SpecsId;
    @JsonProperty("price")
    BigDecimal specsPrice;
    @JsonProperty("stock_num")
    Integer specsStock;
}
