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
public class PhoneSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer specsId;
    Integer phoneId;
    String specsName;
    Integer specsStock;
    BigDecimal specsPrice;
    String specsIcon;
    String specsPreview;
    Date createTime;
    Date updateTime;
}
