package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.domain.OrderDetail;
import com.wxz.ibook.enums.ExceptionEnum;
import com.wxz.ibook.exception.IbookException;
import com.wxz.ibook.repository.OrderDetailRepository;
import com.wxz.ibook.service.OrderDetailService;
import com.wxz.ibook.utils.BigDecimalUtil;
import com.wxz.ibook.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangxingze
 * @date 2019-06-08 15:43
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository detailRepository;

    @Override
    public OrderDetail findOneById(String id) {
        return detailRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return detailRepository.save(orderDetail);
    }

    @Override
    public  List<OrderDetail> saveList(List<OrderDetail> orderDetailList){
        return  detailRepository.saveAll(orderDetailList);
    }
    @Override
    public List<OrderDetail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public List<OrderDetail> findListByOrderIdList(List<String> orderIdList) {
        return detailRepository.findByOrderIdIn(orderIdList);
    }

    @Override
    public Map<String,Object> create(Map<String,Object> bookMap, List<BookInfo> bookInfoList,BigDecimal amount,String orderId) throws Exception{

        BigDecimal reTotalAmount=new BigDecimal(0);
        List<OrderDetail> orderDetailList=new ArrayList<>();
        for (BookInfo bookInfo:bookInfoList){
            Integer quantity=(Integer) bookMap.get(bookInfo.getBookId());
            //数量<1的忽略
            if (quantity>0) {
                //设置属性
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailId(KeyUtil.getUniqueKey());
                orderDetail.setOrderId(orderId);
                orderDetail.setBookQuantity(quantity);
                orderDetail.setBookPrice(bookInfo.getBookPrice());
                orderDetail.setBookName(bookInfo.getBookName());
                orderDetail.setBookIcon(bookInfo.getBookIcon());
                //检查库存
                if(bookInfo.getBookStock()<quantity){
                   throw new IbookException(ExceptionEnum.BOOKSTOCK_NOT_ENOUGP);
                }
                //扣库存
                bookInfo.setBookStock(bookInfo.getBookStock()-quantity);
                reTotalAmount=reTotalAmount.add(new BigDecimal(quantity*(bookInfo.getBookPrice().doubleValue())));
                //添加详情
                orderDetailList.add(orderDetail);
            }

        }
        //检查前后端的金额
        if (BigDecimalUtil.compare(reTotalAmount,amount)!=0){
            throw new IbookException(ExceptionEnum.ORDER_AMOUNT_NOT_ACCORD);
        }
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("bookInfoList",bookInfoList);
        resultMap.put("orderDetailList",orderDetailList);
        return resultMap;
    }

}
