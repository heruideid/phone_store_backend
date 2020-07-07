package com.nostalgia.phone_store_backend.service.impl;

import com.nostalgia.phone_store_backend.entity.BuyerAddress;
import com.nostalgia.phone_store_backend.form.AddressForm;
import com.nostalgia.phone_store_backend.repository.BuyerAddressRepository;
import com.nostalgia.phone_store_backend.service.AddressService;
import com.nostalgia.phone_store_backend.vo.AddressVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    BuyerAddressRepository buyerAddressRepository;

    @Override
    public List<AddressVO> findAllAddress() {
        List<AddressVO> addressVOList=new ArrayList<>();
        List<BuyerAddress> buyerAddressList=buyerAddressRepository.findAll();
        AddressVO addressVO;
        for (BuyerAddress buyerAddress : buyerAddressList) {
            addressVO=new AddressVO();
            BeanUtils.copyProperties(buyerAddress,addressVO);
            addressVOList.add(addressVO);
        }
        return addressVOList;
    }

    @Override
    public String createOrUpdateAddress(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if(addressForm.getId()==null)
            buyerAddress=new BuyerAddress();
        else
            buyerAddress=buyerAddressRepository.findById(addressForm.getId()).get();

        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        StringBuffer address=new StringBuffer();
        if(addressForm.getProvince().equals("北京市")
                ||addressForm.getProvince().equals("天津市")
                || addressForm.getProvince().equals("重庆市")
                ||addressForm.getProvince().equals("上海市"))
            address.append(addressForm.getCity())
                    .append(addressForm.getCounty())
                    .append(addressForm.getAddressDetail());
        else
            address.append(addressForm.getProvince())
                    .append(addressForm.getCity())
                    .append(addressForm.getCounty())
                    .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(address.toString());
        System.out.println(buyerAddress);
        if(buyerAddressRepository.save(buyerAddress)!=null) return "success";
        return "fail";
    }


}
