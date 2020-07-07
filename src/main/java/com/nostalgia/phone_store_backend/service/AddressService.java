package com.nostalgia.phone_store_backend.service;

import com.nostalgia.phone_store_backend.form.AddressForm;
import com.nostalgia.phone_store_backend.vo.AddressVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> findAllAddress();
    public String createOrUpdateAddress(AddressForm addressForm);
}
