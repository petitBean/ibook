package com.wxz.ibook.service;

import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.domain.OrderMaster;

import java.util.List;
import java.util.Map;

public interface BookCartService {

    public void saveOrderMasterAndOrderDetail(Map<String, Object> result,
                                              OrderMaster orderMaster) throws Exception;


    void saveOrderMasterAndBookInfo(List<BookInfo> bookInfoList,OrderMaster orderMaster)throws Exception;
}
