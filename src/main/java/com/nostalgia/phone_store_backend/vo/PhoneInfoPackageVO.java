package com.nostalgia.phone_store_backend.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PhoneInfoPackageVO {
    List<CategoryVO>  categories;
    List<PhoneInfoVO> phones;
}
