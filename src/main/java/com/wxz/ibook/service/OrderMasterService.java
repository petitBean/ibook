package com.wxz.ibook.service;

import com.wxz.ibook.domain.Buyer;
import com.wxz.ibook.domain.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface OrderMasterService {

     OrderMaster findOneById(String id);

     OrderMaster save(OrderMaster orderMaster);

     List<OrderMaster> findAll();

     /**
      * 根据用户购物车生成订单
      * @return
      */
     OrderMaster create( Buyer buyer);

     Page<OrderMaster> findPageByOrderId(String orderId, Pageable pageable);

     List<OrderMaster> findListByBuyerPhone(String buyerPhone);
}
