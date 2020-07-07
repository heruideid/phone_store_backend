package com.nostalgia.phone_store_backend.controller;

import com.nostalgia.phone_store_backend.form.OrderForm;
import com.nostalgia.phone_store_backend.service.OrderService;
import com.nostalgia.phone_store_backend.vo.OrderVO;
import com.nostalgia.phone_store_backend.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping("/create")
    public ResultVO createOrder(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResultVO(1,"失败",null);
        }
        try{
            String orderId=orderService.createOrder(orderForm);

            if(orderId!=null){
                Map<String,String> map=new HashMap<>();
                map.put("orderId",orderId);
                return new ResultVO(0,"成功",map);
            }
            return new ResultVO(1,"失败",null);
        }catch(Exception e){
            e.printStackTrace();
            return new ResultVO(1,"失败",null);
        }
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO orderDetail(@PathVariable String orderId){
        try{
            OrderVO orderVO=orderService.orderDetail(orderId);
            return new ResultVO(0,"成功",orderVO);
        }catch(Exception e){
            return new ResultVO(1,"失败",null);
        }
    }

    @PutMapping("/pay/{orderId}")
    public ResultVO payOrder(@PathVariable String orderId){
        try{
            orderService.payOrder(orderId);
            Map<String,String> map=new HashMap();
            map.put("orderId",orderId);
            return new ResultVO(0,"成功",map);
        }catch (Exception e){
            return new ResultVO(1,"失败",null);
        }
    }






}
