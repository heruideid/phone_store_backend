package com.nostalgia.phone_store_backend.enums;

import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
public enum PayStatus {
    PAID(1,"已支付"),UNPAID(0,"未支付");

    private Integer code;
    private String msg;

    PayStatus(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
