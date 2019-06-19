package com.wxz.ibook.controller;

import com.wxz.ibook.config.ProjectConfig;
import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.domain.OrderDetail;
import com.wxz.ibook.domain.OrderMaster;
import com.wxz.ibook.enums.OrderStatusEnum;
import com.wxz.ibook.enums.PayStatusEnum;
import com.wxz.ibook.service.ServiceImpl.BookCartServiceImpl;
import com.wxz.ibook.service.ServiceImpl.BookInfoServiceImpl;
import com.wxz.ibook.service.ServiceImpl.OrderDetailServiceImpl;
import com.wxz.ibook.service.ServiceImpl.OrderMasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.util.*;

/**
 * @author Wangxingze
 * @date 2019-06-19 19:21
 */
@Controller
@RequestMapping(value = "/buyer/order")
public class OrderController {

    @Autowired
    private OrderDetailServiceImpl orderDetailService;
    @Autowired
    private BookInfoServiceImpl bookInfoService;
    @Autowired
    private OrderMasterServiceImpl orderMasterService;
    @Autowired
    private BookCartServiceImpl bookCartService;
    @Autowired
    private ProjectConfig projectConfig;

@GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "orderId")String orderId,Map<String,Object>map){
    //查询所有详情，放到map中
   // Map<String, OrderDetail> detailMap=new HashMap<>();
    List<String> idList= Arrays.asList(orderId);
    List<BookInfo> bookInfoList=new ArrayList<>();
    List<OrderDetail> detailList=orderDetailService.findListByOrderIdList(idList);
    //TODO 重构,同名书籍问题
    for(OrderDetail detail:detailList){
        //查询所有书籍
        List<BookInfo> bookInfos=bookInfoService.findAllByName(detail.getBookName());
        for(BookInfo bookInfo:bookInfos){
            //加库存
            bookInfo.setBookStock(bookInfo.getBookStock()+detail.getBookQuantity());
            //
            bookInfoList.add(bookInfo);
        }
    }
    //查
    OrderMaster orderMaster=orderMasterService.findOneById(orderId);
    //更改master状态\
    orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
    orderMaster.setPayStatus(PayStatusEnum.CANCEL_ORDER.getCode());
    //存储书籍和master
    try{
        bookCartService.saveOrderMasterAndBookInfo(bookInfoList,orderMaster);
    }
    catch (Exception e){
        map.put("url","/ibook/buyer/book/list");
        map.put("msg","系统异常");
        return new ModelAndView("common/error",map);
    }
    return new ModelAndView("redirect:".concat(projectConfig.getIbook()).concat("/buyer/book/cart/ordermasterlist"));
 }



}
