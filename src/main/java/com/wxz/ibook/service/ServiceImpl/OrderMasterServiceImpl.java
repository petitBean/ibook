package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.DataTransObject.OrderDTO;
import com.wxz.ibook.domain.Buyer;
import com.wxz.ibook.domain.OrderMaster;
import com.wxz.ibook.repository.OrderMasterRepository;
import com.wxz.ibook.service.OrderMasterService;
import com.wxz.ibook.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author Wangxingze
 * @date 2019-06-08 01:16
 */
@Service
@Slf4j
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderMaster findOneById(String id) {
        return orderMasterRepository.findById(id).orElse(null);
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return orderMasterRepository.save(orderMaster);
    }

    @Override
    public List<OrderMaster> findAll(){
        return orderMasterRepository.findAll();
    }

    public  OrderMaster create(Buyer buyer){
        //TODO
        OrderMaster master=new OrderMaster();
        //添加用户信息
        master.setOrderId(KeyUtil.getUniqueKey());
        master.setBuyerPhone(buyer.getBuyerPhone());
        master.setBuyerName(buyer.getBuyerName());
        master.setBuyerAddress(buyer.getBuyerAddress());
        master.setBuyerAccount(buyer.getBuyerAccount());
        master.setBuyerId(buyer.getBuyerId());
        return master;
    }


    public Page<OrderMaster> findPageByOrderId(String orderId, Pageable pageable){
        Page<OrderMaster> orderMasterPage=orderMasterRepository.findByOrderId(orderId,pageable);
        return  orderMasterPage;
    }


    public List<OrderMaster> findListByBuyerPhone(String buyerPhone){
        return orderMasterRepository.findOrderMasterByBuyerPhone(buyerPhone);
    }

}
