package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.domain.OrderDetail;
import com.wxz.ibook.domain.OrderMaster;
import com.wxz.ibook.enums.ExceptionEnum;
import com.wxz.ibook.exception.IbookException;
import com.wxz.ibook.service.BookCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

/**
 * @author Wangxingze
 * @date 2019-06-19 15:10
 */
@Service
public class BookCartServiceImpl implements BookCartService {
    @Autowired
    private OrderDetailServiceImpl orderDetailService;
    @Autowired
    private OrderMasterServiceImpl orderMasterService;
    @Autowired
    private  BookInfoServiceImpl bookInfoService;


    @Override
    @Transactional (rollbackFor = RuntimeException.class)
    public void saveOrderMasterAndOrderDetail(Map<String, Object> result,
                                              OrderMaster orderMaster) throws Exception{
        List<OrderDetail> orderDetailList=(List<OrderDetail>)result.get("orderDetailList");
        List<BookInfo> bookInfoList=(List<BookInfo>)result.get("bookInfoList");
        try {
            orderDetailService.saveList(orderDetailList);
            bookInfoService.saveList(bookInfoList);
            orderMasterService.save(orderMaster);
        }
        catch (Exception e){
            //回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//如果抛了异常
            //抛出异常
            throw  new IbookException(ExceptionEnum.SAVE_ORDER_FAILED);
        }

    }


    @Transactional(rollbackFor = RuntimeException.class)
   public void saveOrderMasterAndBookInfo(List<BookInfo> bookInfoList,OrderMaster orderMaster){
        try{
            bookInfoService.saveList(bookInfoList);
            orderMasterService.save(orderMaster);
        }
        catch (Exception e){
            //回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//如果抛了异常
            throw new IbookException(ExceptionEnum.SAVE_ORDER_FAILED);
        }
   }


}
