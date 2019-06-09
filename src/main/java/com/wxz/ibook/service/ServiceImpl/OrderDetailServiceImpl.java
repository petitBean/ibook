package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.OrderDetail;
import com.wxz.ibook.repository.OrderDetailRepository;
import com.wxz.ibook.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<OrderDetail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public List<OrderDetail> findListByOrderIdList(List<String> orderIdList) {
        return detailRepository.findByOrderIdIn(orderIdList);
    }

}
