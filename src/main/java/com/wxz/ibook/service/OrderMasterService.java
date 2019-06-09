package com.wxz.ibook.service;

import com.wxz.ibook.domain.OrderMaster;

import java.util.List;

public interface OrderMasterService {

     OrderMaster findOneById(String id);

     OrderMaster save(OrderMaster orderMaster);

     List<OrderMaster> findAll();
}
