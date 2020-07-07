package com.nostalgia.phone_store_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class PhoneInfoVO {
    @JsonProperty("id")
    Integer phoneId;
    @JsonProperty("title")
    String phoneName;
    String price;
    @JsonProperty("desc")
    String phoneDescription;
    @JsonProperty("tag")
    List<Map<String,String>> phoneTag;
    @JsonProperty("thumb")
    String phoneIcon;
}
