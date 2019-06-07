package com.wxz.ibook.service;

import com.wxz.ibook.domain.OrderMaster;

public interface OrderMasterService {

    public OrderMaster findOneById(String id);

    public OrderMaster save(OrderMaster orderMaster);
}
