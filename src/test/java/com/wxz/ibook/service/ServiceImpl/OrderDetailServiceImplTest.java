package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.OrderDetail;
import com.wxz.ibook.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailServiceImplTest {

    @Autowired
    private OrderDetailServiceImpl orderDetailService;
    @Test
    public void findOneById() {
    }

    @Test
    public void save() {

        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setOrderDetailId(KeyUtil.getUniqueKey());
        orderDetail.setBookIcon("#");
        orderDetail.setBookName("红玫瑰与白玫瑰");
        orderDetail.setBookPrice(new BigDecimal(52.5));
        orderDetail.setBookQuantity(2);
        orderDetail.setOrderId("1559929477832913748");
        OrderDetail re=orderDetailService.save(orderDetail);
        Assert.assertNotNull(re);
    }

    @Test
    public void findAll() {
        List<OrderDetail> re=orderDetailService.findAll();
        Assert.assertEquals(2,re.size());
    }

    @Test
    public void findListByOrderIdList() {
        List<String> orderIdlist= Arrays.asList("1559929477832913748");
        List<OrderDetail> re=orderDetailService.findListByOrderIdList(orderIdlist);
        Assert.assertEquals(1,re.size());
    }
}