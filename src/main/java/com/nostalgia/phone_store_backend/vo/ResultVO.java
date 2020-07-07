package com.nostalgia.phone_store_backend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultVO {
    Integer code;
    String msg;
    Object data;
}
