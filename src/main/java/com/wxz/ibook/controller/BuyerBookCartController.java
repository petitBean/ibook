package com.wxz.ibook.controller;

import com.wxz.ibook.DataTransObject.BookCart;
import com.wxz.ibook.DataTransObject.OrderDTO;
import com.wxz.ibook.config.ProjectConfig;
import com.wxz.ibook.constrant.CookieConstrant;
import com.wxz.ibook.constrant.SessionConstrant;
import com.wxz.ibook.converter.OrderMasterConverter;
import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.domain.Buyer;
import com.wxz.ibook.domain.OrderDetail;
import com.wxz.ibook.domain.OrderMaster;
import com.wxz.ibook.enums.ExceptionEnum;
import com.wxz.ibook.exception.IbookException;
import com.wxz.ibook.service.ServiceImpl.*;
import com.wxz.ibook.utils.CookieUtil;
import com.wxz.ibook.utils.KeyUtil;
import com.wxz.ibook.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Wangxingze
 * @date 2019-06-17 16:34
 */
@Controller
@Slf4j
@RequestMapping("/buyer/book/cart")
public class BuyerBookCartController {

    @Autowired
    private BookInfoServiceImpl bookInfoService;
    @Autowired
    private ProjectConfig projectConfig;
    @Autowired
    private BuyerServiceImpl buyerService;
    @Autowired
    private OrderDetailServiceImpl orderDetailService;
    @Autowired
    private OrderMasterServiceImpl orderMasterService;
    @Autowired
    private BookCartServiceImpl bookCartService;


    /**
     * session存储购物车信息
     * @param request
     * @param bookQuantityText
     * @param bookId
     * @return
     */
    @PostMapping(value = "/addToCart")
    public ModelAndView addToCart(HttpServletRequest request,
                                  @RequestParam(value = "bookQuantity",required = true)String bookQuantityText,
                                  @RequestParam(value = "bookId",required = true)String bookId){
        Map<String,Object> resultMap=new HashMap<>();
        Integer bookQuantity=0;
        try {
            bookQuantity = Integer.parseInt(bookQuantityText);
        }catch (Exception e){
            System.out.println("数据转换出错！"+"\n"+e.getMessage());
            resultMap.put("url","/ibook/buyer/book/list");
            resultMap.put("msg","输入的数据格式不对！");
            return new ModelAndView("common/error",resultMap);
        }
        //1.获取session
        HttpSession session=request.getSession();
        //TODO 使用sessionid
        //2.seesion获取map
        Map<String,Integer> map=(Map<String, Integer>) session.getAttribute(SessionConstrant.BOOK_MAP);
        //3.判断是否为空
        if (map==null){
            map=new HashMap<>();
        }
        //4.添加货物（判断库存等），此处不用
       BookInfo bookInfo=bookInfoService.findOneById(bookId);
        if(bookInfo.getBookStock()<bookQuantity){
            resultMap.put("url","/ibook/buyer/book/list");
            resultMap.put("msg","库存不够！");
            return new ModelAndView("common/error",resultMap);
        }
        if(bookQuantity<=0){
            resultMap.put("url","/ibook/buyer/book/list");
            resultMap.put("msg","请添加至少一件商品！");
            return new ModelAndView("common/error",resultMap);
        }
        if (map.containsKey(bookId)){
            bookQuantity+=map.get(bookId);
        }
        map.put(bookId,bookQuantity);
        //5.保存map到session
        session.setAttribute(SessionConstrant.BOOK_MAP,map);
        //sessionId=buyerPhone
        SessionUtil.add(CookieUtil.get(request, CookieConstrant.BUYER_ID).getValue(),session);
        if (bookQuantity==1){
            System.out.print("OK");
        }
        resultMap.put("url","/ibook/buyer/book/list");
        resultMap.put("msg","添加成功！");
        return new ModelAndView("common/success",resultMap);
    }


    /**
     * 查看购物车
     * @param request
     * @return
     */
    @GetMapping("/showcart")
    public ModelAndView showCart(HttpServletRequest request){
        //应用于存储返回的cart
        List<BookCart> bookCartList=new ArrayList<>();
        //存放结果map
        Map<String,Object> resultCartMap=new HashMap<>();
        //1.获取sessionid
        //TODO 如果未登录或者长时间未重新登陆无法获取id，后期登录控制
        String sessionId=CookieUtil.get(request,CookieConstrant.BUYER_ID).getValue();
        //获取session，没有添加过商品为null
        HttpSession session=SessionUtil.get(sessionId);

        if(session==null){
           //返回数据为空
            resultCartMap.put("cartList",null);
            return new ModelAndView("bookcart/bookcart",resultCartMap);
        }
        //查询书籍信息
        Map<String,Integer> bookMap=null;
        bookMap= (Map<String,Integer>)session.getAttribute(SessionConstrant.BOOK_MAP);
        //String[] idArray=(String[]) ((bookMap.keySet()).toArray());
        if(bookMap==null){
            resultCartMap.put("cartList",null);
            return new ModelAndView("bookcart/bookcart",resultCartMap);
        }
        //用于存放书籍id
        List<String> bookIdList=new ArrayList<>();
        Iterator iterator=((bookMap.keySet())).iterator();
        while (iterator.hasNext()){
            String id=(String )iterator.next();
            bookIdList.add(id);
;        }
        //查询书籍信息
        List<BookInfo> bookInfoList=bookInfoService.findListByBookIdList(bookIdList );
        //将信息添加到list
        for (BookInfo bookInfo:bookInfoList){
            if(bookMap.containsKey(bookInfo.getBookId())){
               BookCart bookCart=new BookCart(bookMap.get(bookInfo.getBookId()),bookInfo);
               bookCartList.add(bookCart);
            }
        }
        resultCartMap.put("cartList",bookCartList);
        return new ModelAndView("bookcart/bookcart",resultCartMap);
    }

    /**
     * 将一个商品移出购物车
     * @return
     */
    @GetMapping(value = "/delete")
    public ModelAndView delete(@RequestParam(value = "bookId",required = true) String bookId,
                               HttpServletRequest request,
                               Map<String,Object> resultMap){
       HttpSession session=request.getSession();
       if (session==null){
           log.error("【购物车操作】删除商品，session为空,bookId={}",bookId );
           resultMap.put("msg","系统刷新！");
           resultMap.put("url","/ibook/buyer/book/list");
       }
       Map<String,Object> map=(Map<String,Object>)session.getAttribute(SessionConstrant.BOOK_MAP);
       if (map.containsKey(bookId)){
           map.remove(bookId);
       }
       else {
           log.error("【购物车操作】商品不在session中,bookId={}",bookId );
           resultMap.put("msg","系统刷新！");
           resultMap.put("url","/ibook/buyer/book/list");
       }
       return new ModelAndView("redirect:".
               concat(projectConfig.getIbook()
               .concat("/buyer/book/cart/showcart")));
    }

    //创建订单
    @GetMapping(value = "/createorder")
    public ModelAndView pay(@RequestParam(value = "totalAmount")String totalAmonut,
                            HttpServletRequest request,
                            Map<String,Object> map){

        //1.数据检查
       List<String> bookIdList=SessionUtil.getBookIdList(request);
        if (bookIdList==null) {
            log.error("【创建订单】sessionUtil返回为空");
            map.put("msg","系统错误！重新登录！");
            map.put("url","/ibook/buyer/user/logout");
            return new ModelAndView("common/error",map);
        }
        BigDecimal amount;
        try{
            amount=BigDecimal.valueOf(Double.parseDouble(totalAmonut));
        }
        catch(Exception e){
            log.error("【创建订单】订单金额状态不正确！orderAmount={}",totalAmonut);
            map.put("msg","订单金额状态不正确！重新登录！");
            map.put("url","/ibook/buyer/user/logout");
            return new ModelAndView("common/error",map);
        }
        //2.查询用户
        String buyerPhone=CookieUtil.get(request,CookieConstrant.BUYER_ID).getValue();
        //判断号码
        if (buyerPhone==null){
            log.error("【创建订单】cookie中查询不到用户信息,attributeName={}",CookieConstrant.BUYER_ID);
            map.put("msg","用户登录状态不正确！重新登录！");
            map.put("url","/ibook/buyer/user/logout");
            return new ModelAndView("common/error",map);
        }
        Buyer buyer;
        try {
            buyer = buyerService.findOneByBuyerPhone(buyerPhone);
            if (buyer==null){
                log.error("【创建订单】数据库查询不到用户！buyerPhonr={}",buyerPhone);
                throw new IbookException(ExceptionEnum.BUYER_INFO_NULL);
            }
        }
        catch (Exception e){
            map.put("msg","用户信息不正确！重新登录！");
            map.put("url","/ibook/buyer/user/logout");
            return new ModelAndView("common/error",map);
        }
        //创建ordermaster
        OrderMaster orderMaster=orderMasterService.create(buyer);
        //设置金额
        orderMaster.setOrderAmount(amount);
        //查询书籍id信息
        Map<String,Object> bookMap=SessionUtil.getBookMap(request);
        List<BookInfo> bookInfoList=bookInfoService.findListByBookIdList(bookIdList);
        Map<String, Object> result=new HashMap<>();
        if(bookInfoList!=null){
            //新建订单详情
            try {
                 result = orderDetailService.create(bookMap, bookInfoList, amount, orderMaster.getOrderId());
                //3.提交数据
                bookCartService.saveOrderMasterAndOrderDetail(result,orderMaster);
            }
            catch (Exception e){
                log.error("【创建订单】 系统出错！errorMessage={}",e.getMessage());
                map.put("msg",e.getMessage());
                map.put("url","/ibook/buyer/user/logout");
                return new ModelAndView("common/error",map);
            }
        }
        //4.qin清空购物车
        SessionUtil.clear(request,SessionConstrant.BOOK_MAP);
        map.put("msg","前往支付");
        map.put("url","/ibook/buyer/book/list");
       return new ModelAndView("common/success",map);
        //TODO 5.支付

    }

    @GetMapping(value = "/ordermasterlist")
    public ModelAndView orderMasterList(HttpServletRequest request,Map<String,Object> map){
        String buyerPhone=CookieUtil.get(request,CookieConstrant.BUYER_ID).getValue();
        List<OrderMaster> orderMasterList=orderMasterService.findListByBuyerPhone(buyerPhone);
        List<OrderDTO> orderDTOList= OrderMasterConverter.convert(orderMasterList);
        map.put("orderDTOList",orderMasterList);
        return new ModelAndView("order/list",map);
    }

    @GetMapping(value = "/detail")
    public ModelAndView detail(@RequestParam(value = "orderId")String orderId,
                               Map<String,Object> map){
        List<String> oderIdList=Arrays.asList(orderId);
        List<OrderDetail> orderDetailList=orderDetailService.findListByOrderIdList(oderIdList);
        OrderMaster orderDTO=orderMasterService.findOneById(orderId);
        map.put("detailList",orderDetailList);
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }



}//con
