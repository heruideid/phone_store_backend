package com.nostalgia.phone_store_backend.service.impl;

import com.nostalgia.phone_store_backend.entity.OrderMaster;
import com.nostalgia.phone_store_backend.entity.PhoneInfo;
import com.nostalgia.phone_store_backend.entity.PhoneSpecs;
import com.nostalgia.phone_store_backend.enums.PayStatus;
import com.nostalgia.phone_store_backend.enums.ResultEnum;
import com.nostalgia.phone_store_backend.exception.MyException;
import com.nostalgia.phone_store_backend.form.OrderForm;
import com.nostalgia.phone_store_backend.repository.OrderMasterRepository;
import com.nostalgia.phone_store_backend.repository.PhoneInfoRepository;
import com.nostalgia.phone_store_backend.repository.PhoneSpecsRepository;
import com.nostalgia.phone_store_backend.service.OrderService;
import com.nostalgia.phone_store_backend.util.OrderUtil;
import com.nostalgia.phone_store_backend.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import java.math.BigDecimal;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    PhoneInfoRepository phoneInfoRepository;

    @Autowired
    PhoneSpecsRepository phoneSpecsRepository;

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Override
    public String createOrder(OrderForm orderForm) {
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setBuyerAddress(orderForm.getAddress());
        orderMaster.setBuyerName(orderForm.getName());
        orderMaster.setBuyerPhone(orderForm.getTel());
        orderMaster.setSpecsId(orderForm.getSpecsId());
        orderMaster.setPhoneQuantity(orderForm.getQuantity());

        PhoneSpecs phoneSpecs=phoneSpecsRepository.findById(orderForm.getSpecsId()).get();
        PhoneInfo phoneInfo=phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        orderMaster.setPhoneId(phoneInfo.getPhoneId());
        orderMaster.setPhoneIcon(phoneInfo.getPhoneIcon());
        orderMaster.setPhoneName(phoneInfo.getPhoneName());
        orderMaster.setSpecsName(phoneSpecs.getSpecsName());
        orderMaster.setSpecsPrice(phoneSpecs.getSpecsPrice());
        orderMaster.setOrderAmount(phoneSpecs.getSpecsPrice().multiply(BigDecimal.valueOf(orderForm.getQuantity())));
        orderMaster.setPayStatus(PayStatus.UNPAID.getCode());
        orderMaster.setOrderId(OrderUtil.getUniqueKey());

       if(orderMasterRepository.save(orderMaster)!=null) return orderMaster.getOrderId();
       return null;
    }

    @Override
    public OrderVO orderDetail(String orderId) {

        OrderMaster orderMaster=orderMasterRepository.findById(orderId).get();
        OrderVO orderVO=new OrderVO();
        BeanUtils.copyProperties(orderMaster,orderVO);
        orderVO.setSpecsPrice(orderMaster.getSpecsPrice()+"");
        return orderVO;
    }

    @Override
    public void payOrder(String orderId){
        System.out.println(orderId);
        OrderMaster orderMaster=orderMasterRepository.findById(orderId).get();
        if(orderMaster==null){
            log.error(ResultEnum.ORDER_NOT_EXIST.getMsg());
            throw new MyException(ResultEnum.ORDER_NOT_EXIST);
        }
        Integer phoneId=orderMaster.getPhoneId();
        Integer specsId=orderMaster.getSpecsId();
        subStock(phoneId,specsId,orderMaster.getPhoneQuantity());
        orderMaster.setPayStatus(PayStatus.PAID.getCode());
        orderMasterRepository.save(orderMaster);
    }

    private void subStock(Integer phoneId, Integer specsId,Integer quantity){
        PhoneInfo phoneInfo=phoneInfoRepository.findById(phoneId).get();
        PhoneSpecs phoneSpecs=phoneSpecsRepository.findById(specsId).get();
        if(phoneInfo.getPhoneStock()<quantity||phoneSpecs.getSpecsStock()<quantity){
            log.error(ResultEnum.PHONE_STOCK_ERROR.getMsg());
            throw new MyException(ResultEnum.PHONE_STOCK_ERROR);
        }
        else{
            phoneInfo.setPhoneStock(phoneInfo.getPhoneStock()-quantity);
            phoneSpecs.setSpecsStock(phoneSpecs.getSpecsStock()-quantity);
            phoneInfoRepository.save(phoneInfo);
            phoneSpecsRepository.save(phoneSpecs);
        }
    }
}
