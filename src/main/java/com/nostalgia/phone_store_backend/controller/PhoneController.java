package com.nostalgia.phone_store_backend.controller;

import com.nostalgia.phone_store_backend.entity.PhoneCategory;
import com.nostalgia.phone_store_backend.entity.PhoneInfo;
import com.nostalgia.phone_store_backend.entity.PhoneSpecs;
import com.nostalgia.phone_store_backend.repository.PhoneCategoryRepository;
import com.nostalgia.phone_store_backend.repository.PhoneInfoRepository;
import com.nostalgia.phone_store_backend.repository.PhoneSpecsRepository;
import com.nostalgia.phone_store_backend.service.PhoneService;
import com.nostalgia.phone_store_backend.vo.PhoneInfoPackageVO;
import com.nostalgia.phone_store_backend.vo.PhoneInfoVO;
import com.nostalgia.phone_store_backend.vo.ResultVO;
import com.nostalgia.phone_store_backend.vo.SpecsPackageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    PhoneService phoneService;

    @GetMapping("/index")
    public ResultVO index(){
        try {
            PhoneInfoPackageVO phoneInfoPackageVO=phoneService.index();
            return new ResultVO(1,"成功",phoneInfoPackageVO);
        }catch (Exception e){
            return new ResultVO(0,"失败",null);
        }
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(@PathVariable Integer categoryType){
       try{
           List<PhoneInfoVO> phoneInfoVOs=phoneService.findByCategoryType(categoryType);
           return new ResultVO(0,"成功",phoneInfoVOs);
       } catch (Exception e) {
           return new ResultVO(1,"失败",null);
       }
    }

    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVO findSpecsByPhoneId(@PathVariable Integer phoneId){
        try{
            SpecsPackageVO specsPackageVO=phoneService.findSpecsByPhoneId(phoneId);
            return new ResultVO(0,"成功",specsPackageVO);
        }catch(Exception e){
            return new ResultVO(1,"失败",null);
        }
    }



}
