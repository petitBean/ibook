package com.wxz.ibook.repository;

import com.wxz.ibook.domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * orderDetail
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String > {

    List<OrderDetail> findByOrderIdIn(List<String> orderIdList);
}
