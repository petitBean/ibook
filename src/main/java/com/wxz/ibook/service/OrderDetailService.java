package com.wxz.ibook.service;

import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.domain.OrderDetail;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrderDetailService {

    OrderDetail findOneById(String id);

    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> saveList(List<OrderDetail> orderDetailList);

    List<OrderDetail> findAll();

    /**
     * 查询属于订单列表里所有订单的订单详情
     * @param orderIdList
     * @return
     */
    List<OrderDetail> findListByOrderIdList(List<String> orderIdList);

    Map<String,Object> create(Map<String,Object> bookMap, List<BookInfo> bookInfoList, BigDecimal amount, String orderId)throws Exception;

}
