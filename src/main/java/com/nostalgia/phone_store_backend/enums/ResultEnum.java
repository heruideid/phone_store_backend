package com.nostalgia.phone_store_backend.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PHONE_STOCK_ERROR(0,"库存不足"),
    ORDER_NOT_EXIST(1,"订单不存在");

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
