package com.wxz.ibook.converter;

import com.wxz.ibook.DataTransObject.OrderDTO;
import com.wxz.ibook.domain.OrderMaster;
import freemarker.cache.OrMatcher;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wangxingze
 * @date 2019-06-19 17:09
 */
public class OrderMasterConverter {


    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
