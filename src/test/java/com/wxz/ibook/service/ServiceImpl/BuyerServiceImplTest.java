package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.Buyer;
import com.wxz.ibook.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BuyerServiceImplTest {

    @Autowired
    private BuyerServiceImpl buyerService;


    @Test
    public void findOne() throws Exception {
        Buyer re=buyerService.findOne("92780");
        Assert.assertEquals(re.getBuyerAddress(),"武汉理工大学");
    }

    @Test
    public void save() throws Exception {
        Buyer buyer=new Buyer();
        buyer.setBuyerId(KeyUtil.getUniqueKey());
        buyer.setBuyerAccount("789345");
        buyer.setBuyerAddress("武汉理工大学");
        buyer.setBuyerName("张三");
        buyer.setBuyerPhone("18755830284");
        buyer.setPassword("123456");
        buyer.setBuyerIcon("#");
        Buyer re=buyerService.save(buyer);
        Assert.assertNotNull(re);
    }

    @Test
    public void findListByPhone()throws Exception {
        List<Buyer> re=buyerService.findListByBuyerPhone("18755830284");
        Assert.assertEquals(1,re.size());
    }

    @Test
    public void findByPhone()throws Exception {
        Buyer re=buyerService.findOneByBuyerPhone("18755830284");
        Assert.assertNotNull(re);
    }
}