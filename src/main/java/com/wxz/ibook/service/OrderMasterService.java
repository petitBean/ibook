package com.wxz.ibook.service;

import com.wxz.ibook.domain.OrderMaster;

import java.util.List;
import java.util.Map;

public interface OrderMasterService {

     OrderMaster findOneById(String id);

     OrderMaster save(OrderMaster orderMaster);

     List<OrderMaster> findAll();

     /**
      * 根据用户购物车生成订单
      * @param cartMap
      * @return
      */
     OrderMaster createOrder(Map<String,Object> cartMap);
}
