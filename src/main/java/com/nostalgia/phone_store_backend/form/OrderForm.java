package com.nostalgia.phone_store_backend.form;

import lombok.Data;

@Data
public class OrderForm {
    Integer id;
    String name;
    String tel;
    String address;
    Integer specsId;
    Integer quantity;
}
