package com.nostalgia.phone_store_backend.service.impl;

import com.nostalgia.phone_store_backend.entity.PhoneInfo;
import com.nostalgia.phone_store_backend.service.PhoneService;
import com.nostalgia.phone_store_backend.vo.PhoneInfoPackageVO;
import com.nostalgia.phone_store_backend.vo.PhoneInfoVO;
import com.nostalgia.phone_store_backend.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PhoneServiceImplTest {
    @Autowired
    PhoneService phoneService;

    @Test
    void testIndex(){
        PhoneInfoPackageVO phoneInfoPackageVO= phoneService.index();

    }

    @Test
    void testM2(){
        List<PhoneInfoVO> phoneInfos=phoneService.findByCategoryType(1);
    }
}