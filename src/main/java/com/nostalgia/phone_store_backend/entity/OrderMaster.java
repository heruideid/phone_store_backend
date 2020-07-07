package com.nostalgia.phone_store_backend.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class OrderMaster {
    @Id
    String orderId;
    String buyerName;
    String buyerPhone;
    String buyerAddress;
    Integer phoneId;
    String phoneName;
    Integer phoneQuantity;
    String phoneIcon;
    Integer specsId;
    String specsName;
    BigDecimal specsPrice;
    BigDecimal orderAmount;
    Integer payStatus;
    Date createTime;
    Date updateTime;
}
