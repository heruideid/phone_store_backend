package com.nostalgia.phone_store_backend.repository;

import com.nostalgia.phone_store_backend.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
