package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.OrderMaster;
import com.wxz.ibook.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterServiceImplTest {

    @Autowired
    private OrderMasterServiceImpl orderMasterService;

    @Test
    public void findOneById() {
        OrderMaster orderMaster=orderMasterService.findOneById("1559929477832913748");
        Assert.assertNotNull(orderMaster);
    }

    @Test
    public void save() {
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setBuyerId("1559928114660926208");
        orderMaster.setBuyerAccount("123456");
        orderMaster.setBuyerAddress("云南省昆明市寻甸县");
        orderMaster.setBuyerName("wxz");
        orderMaster.setBuyerPhone("13129965536");
        orderMaster.setOrderId(KeyUtil.getUniqueKey());
        orderMaster.setOrderAmount(new BigDecimal(60.5));
        OrderMaster re=orderMasterService.save(orderMaster);
        Assert.assertNotNull(re);

    }
}