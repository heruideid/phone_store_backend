package com.nostalgia.phone_store_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderVO {
    String orderId;
    String buyerName;
    String phoneName;
    Integer payStatus;
    Integer freight=10;
    @JsonProperty("tel")
    String buyerPhone;
    @JsonProperty("address")
    String buyerAddress;
    @JsonProperty("num")
    Integer phoneQuantity;
    @JsonProperty("specs")
    String specsName;
    @JsonProperty("price")
    String specsPrice;
    @JsonProperty("icon")
    String phoneIcon;
    @JsonProperty("amount")
    BigDecimal orderAmount;
}
