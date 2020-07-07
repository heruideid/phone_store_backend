package com.nostalgia.phone_store_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddressVO {
    String areaCode;
    @JsonProperty("id")
    Integer addressId;
    @JsonProperty("name")
    String buyerName;
    @JsonProperty("tel")
    String buyerPhone;
    @JsonProperty("address")
    String buyerAddress;
}
