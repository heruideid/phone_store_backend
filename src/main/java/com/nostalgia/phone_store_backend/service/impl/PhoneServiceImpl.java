package com.nostalgia.phone_store_backend.service.impl;

import com.nostalgia.phone_store_backend.entity.PhoneCategory;
import com.nostalgia.phone_store_backend.entity.PhoneInfo;
import com.nostalgia.phone_store_backend.entity.PhoneSpecs;
import com.nostalgia.phone_store_backend.repository.PhoneCategoryRepository;
import com.nostalgia.phone_store_backend.repository.PhoneInfoRepository;
import com.nostalgia.phone_store_backend.repository.PhoneSpecsRepository;
import com.nostalgia.phone_store_backend.service.PhoneService;
import com.nostalgia.phone_store_backend.util.PhoneUtil;
import com.nostalgia.phone_store_backend.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    PhoneInfoRepository phoneInfoRepository;

    @Autowired
    PhoneCategoryRepository phoneCategoryRepository;

    @Autowired
    PhoneSpecsRepository phoneSpecsRepository;

    @Override
    public PhoneInfoPackageVO index() {
        Integer defaultCategoryType=1;
        List<PhoneInfo> phoneInfos=phoneInfoRepository.findAllByCategoryType(defaultCategoryType);

        PhoneInfoPackageVO phoneInfoPackageVO =new PhoneInfoPackageVO();
        //配置json里的categories属性
        List<CategoryVO> categoryVOs=new ArrayList<>();
        List<PhoneCategory> phoneCategories=phoneCategoryRepository.findAll();
        CategoryVO categoryVO;
        for (PhoneCategory phoneCategory : phoneCategories) {
            categoryVO=new CategoryVO();
            BeanUtils.copyProperties(phoneCategory,categoryVO);
            categoryVOs.add(categoryVO);
        }
        phoneInfoPackageVO.setCategories(categoryVOs);
        //配置json里的phones属性
        List<PhoneInfoVO> phones=new ArrayList<>();
        for (PhoneInfo phoneinfo : phoneInfos) {
            PhoneInfoVO phoneInfoVO=new PhoneInfoVO();
            BeanUtils.copyProperties(phoneinfo,phoneInfoVO);
            phoneInfoVO.setPhoneTag(PhoneUtil.getTags(phoneinfo.getPhoneTag()));
            phones.add(phoneInfoVO);
        }
        phoneInfoPackageVO.setPhones(phones);

        return phoneInfoPackageVO;
    }

    @Override
    public List<PhoneInfoVO> findByCategoryType(Integer categoryType) {
        List<PhoneInfoVO> phoneInfoVOs=new ArrayList<>();
        List<PhoneInfo> phoneInfos=phoneInfoRepository.findAllByCategoryType(categoryType);
        PhoneInfoVO phoneInfoVO;
        for (PhoneInfo phoneInfo : phoneInfos) {
            phoneInfoVO=new PhoneInfoVO();
            BeanUtils.copyProperties(phoneInfo,phoneInfoVO);

            phoneInfoVO.setPrice(phoneInfo.getPhonePrice()+"");
            System.out.println(phoneInfo.getPhonePrice()+"");
            phoneInfoVOs.add(phoneInfoVO);
        }
        return phoneInfoVOs;
    }

    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId){
        SpecsPackageVO specsPackageVO=new SpecsPackageVO();
        List<PhoneSpecs> phoneSpecs=phoneSpecsRepository.findAllByPhoneId(phoneId);
        //如果在数据库未查到相关规格信息，抛出异常,TODO

        //设置goods
        Map<String,String> goods=new HashMap<>();
        goods.put("picture",phoneSpecs.get(0).getSpecsIcon());
        specsPackageVO.setGoods(goods);

        //设置sku属性
        SkuVO skuVO=new SkuVO();
        //设置tree属性
        List<TreeVO> tree=new ArrayList<>();
        TreeVO treeVO=new TreeVO();
        //设置v属性
        List<SpecsIntroductionVO> v=new ArrayList<>();
        List<SpecsStockAndPriceVO> list=new ArrayList<>();
        SpecsIntroductionVO specsIntroductionVO;
        SpecsStockAndPriceVO specsStockAndPriceVO;
        Integer totalStock=0;
        for (PhoneSpecs phoneSpec : phoneSpecs) {
            specsIntroductionVO=new SpecsIntroductionVO();
            specsStockAndPriceVO=new SpecsStockAndPriceVO();
            BeanUtils.copyProperties(phoneSpec,specsIntroductionVO);
            BeanUtils.copyProperties(phoneSpec,specsStockAndPriceVO);
            specsStockAndPriceVO.setSpecsPrice(specsStockAndPriceVO.getSpecsPrice().multiply(new BigDecimal("100")));
            v.add(specsIntroductionVO);
            list.add(specsStockAndPriceVO);
            totalStock+=phoneSpec.getSpecsStock();
        }
        treeVO.setV(v);
        tree.add(treeVO);
        skuVO.setTree(tree);
        //设置sku的子属性list
        skuVO.setList(list);
        //设置sku子属性price
        skuVO.setPrice(phoneSpecs.get(0).getSpecsPrice()+"");
        System.out.println(phoneSpecs.get(0).getSpecsPrice());
        //设置sku子属性stock
        skuVO.setStock_num(totalStock);

        specsPackageVO.setSku(skuVO);

        return specsPackageVO;


    }
}
