package com.nostalgia.phone_store_backend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class PhoneCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer categoryId;
    @NotNull
    String categoryName;
    @NotNull
    Integer categoryType;
    @NotNull
    Date createTime;
    @NotNull
    Date updateTime;

}
