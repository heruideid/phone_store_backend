package com.nostalgia.phone_store_backend.controller;

import com.nostalgia.phone_store_backend.entity.BuyerAddress;
import com.nostalgia.phone_store_backend.form.AddressForm;
import com.nostalgia.phone_store_backend.repository.BuyerAddressRepository;
import com.nostalgia.phone_store_backend.service.AddressService;
import com.nostalgia.phone_store_backend.vo.AddressVO;
import com.nostalgia.phone_store_backend.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/list")
    public ResultVO findAllBuyerAddress(){
        try{
            List<AddressVO> addressVOList= addressService.findAllAddress();
            return new ResultVO(0,"成功",addressVOList);
        }catch (Exception e){
            return new ResultVO(1,"失败",null);
        }
    }

    @PostMapping("/create")
    public ResultVO createBuyerAddress(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加地址】参数错误,addressForm={}",addressForm);
            return new ResultVO(1,"失败",null);
        }
        try{
            String response= addressService.createOrUpdateAddress(addressForm);
            if(response.equals("success")) return new ResultVO(0,"成功",null);
            return new ResultVO(1,"失败",null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultVO(1,"失败",null);
        }
    }

    @PutMapping("/update")
    public ResultVO updateBuyerAddress(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加地址】参数错误,addressForm={}",addressForm);
            return new ResultVO(1,"失败",null);
        }
        try{
            String response= addressService.createOrUpdateAddress(addressForm);
            if(response.equals("success")) return new ResultVO(0,"成功",null);
            return new ResultVO(1,"失败",null);
        }catch (Exception e){
            return new ResultVO(1,"失败",null);
        }
    }


}
