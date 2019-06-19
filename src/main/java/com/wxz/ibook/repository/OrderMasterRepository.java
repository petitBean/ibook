package com.wxz.ibook.repository;

import com.wxz.ibook.domain.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * OrderMaster
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String > {

    Page<OrderMaster> findByOrderId(String orderId, Pageable pageable);

    List<OrderMaster> findOrderMasterByBuyerPhone(String buyerPhone);
}
