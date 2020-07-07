package com.nostalgia.phone_store_backend.service;

import com.nostalgia.phone_store_backend.entity.PhoneInfo;
import com.nostalgia.phone_store_backend.vo.PhoneInfoPackageVO;
import com.nostalgia.phone_store_backend.vo.PhoneInfoVO;
import com.nostalgia.phone_store_backend.vo.SpecsPackageVO;

import java.util.List;

public interface PhoneService {
    public PhoneInfoPackageVO index();
    public List<PhoneInfoVO> findByCategoryType(Integer categoryType);
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId);
}
