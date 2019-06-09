package com.wxz.ibook.service;

import com.wxz.ibook.domain.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    OrderDetail findOneById(String id);

    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> findAll();

    /**
     * 查询属于订单列表里所有订单的订单详情
     * @param orderIdList
     * @return
     */
    List<OrderDetail> findListByOrderIdList(List<String> orderIdList);

}
