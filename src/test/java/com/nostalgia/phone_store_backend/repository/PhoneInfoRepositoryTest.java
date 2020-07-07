package com.nostalgia.phone_store_backend.repository;

import com.nostalgia.phone_store_backend.entity.PhoneInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneInfoRepositoryTest {
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;

    @Test
    void findAllByCategoryType(){
       // List<PhoneInfo> list=phoneInfoRepository.findAllByCategoryType(Integer.valueOf(1));

    }

}