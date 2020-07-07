package com.nostalgia.phone_store_backend.repository;

import com.nostalgia.phone_store_backend.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerAddressRepository extends JpaRepository<BuyerAddress,Integer> {
}
