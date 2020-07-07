package com.nostalgia.phone_store_backend.repository;

import com.nostalgia.phone_store_backend.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory,Integer> {
    public List<PhoneCategory> findPhoneCategoryByCategoryId(Integer categoryId);
}
