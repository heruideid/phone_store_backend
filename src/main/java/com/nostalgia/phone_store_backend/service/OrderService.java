package com.nostalgia.phone_store_backend.service;

import com.nostalgia.phone_store_backend.form.OrderForm;
import com.nostalgia.phone_store_backend.vo.OrderVO;

public interface OrderService {
    public String createOrder(OrderForm orderForm);
    public OrderVO orderDetail(String orderId);
    public void payOrder(String orderId);
}
