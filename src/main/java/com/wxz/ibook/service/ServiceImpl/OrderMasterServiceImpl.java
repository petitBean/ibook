package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.OrderMaster;
import com.wxz.ibook.repository.OrderMasterRepository;
import com.wxz.ibook.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wangxingze
 * @date 2019-06-08 01:16
 */
@Service
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
}
