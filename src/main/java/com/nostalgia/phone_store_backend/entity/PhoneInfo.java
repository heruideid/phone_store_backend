package com.nostalgia.phone_store_backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class PhoneInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer phoneId;
    String phoneName;
    BigDecimal phonePrice;
    String phoneDescription;
    Integer phoneStock;
    String phoneIcon;
    String phoneTag;
    Integer categoryType;
    Date createTime;
    Date updateTime;
}
