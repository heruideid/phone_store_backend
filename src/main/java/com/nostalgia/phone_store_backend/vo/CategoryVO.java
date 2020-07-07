package com.nostalgia.phone_store_backend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {
    @JsonProperty("name")
    String categoryName;
    @JsonProperty("type")
    Integer categoryType;
}
