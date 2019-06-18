package com.wxz.ibook.controller;

import com.wxz.ibook.config.ProjectConfig;
import com.wxz.ibook.constrant.CookieConstrant;
import com.wxz.ibook.domain.Buyer;
import com.wxz.ibook.service.ServiceImpl.BuyerServiceImpl;
import com.wxz.ibook.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wangxingze
 * @date 2019-06-13 18:14
 */
@Controller
@RequestMapping(value = "buyer/user")
@Slf4j
public class BuyerUserController {

    @Autowired
    private BuyerServiceImpl buyerService;
    @Autowired
    private ProjectConfig projectConfig;
    /**
     * 跳转到登录界面
     * @return
     */
    @GetMapping(value = "/tologin")
    public ModelAndView toLogin(){
        return new ModelAndView("user/login");
    }

    /**
     * 跳转到注册界面
     * @return
     */
    @GetMapping(value = "/toregist")
    public ModelAndView toRegist(){
        return new ModelAndView("user/regist");
    }

    /**
     * 登录，保存的cookieName时 buyerId value时buyerPhone
     * @param response
     * @param buyerPhone
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public ModelAndView login(HttpServletResponse response,
                              @RequestParam(value = "buyerPhone" ,required = true) String buyerPhone,
                              @RequestParam(value = "password",required = true)String password){

        //1.检查数据
        Map<String,Object> reMap=new HashMap<>();
        if(password==null || buyerPhone==null){
            reMap.put("msg","信息错误！");
            reMap.put("url","/ibook/buyer/user/tologin");
            return new ModelAndView("common/error",reMap);
        }
        //2.查询用户
        Buyer buyer=null;
        try {
             buyer = buyerService.findOneByBuyerPhone(buyerPhone);
        }catch(Exception e){
            log.error("用户登录错误 buyerPhone={}",buyerPhone);
            reMap.put("msg","登录失败！");
            reMap.put("url","/buyer/user/login/ibook/user/tologin");
            return new ModelAndView("common/error",reMap);
        }
       if (buyer==null){
           reMap.put("msg","该账号不存在！");
           reMap.put("url","/buyer/user/login/ibook/user/tologin");
           return new ModelAndView("common/error",reMap);
       }
       if (buyer.getPassword().equals(password)){
           CookieUtil.set(response, CookieConstrant.BUYER_ID,buyerPhone);
          /* Cookie cookie=new Cookie(buyerPhone,buyer.getBuyerId());
           cookie.setMaxAge(3600);
           cookie.setPath("/");
           response.addCookie(cookie);*/
           return new ModelAndView("redirect:"+projectConfig.getIbook()+"/buyer/book/list");
       }
       else {
           reMap.put("msg","密码不正确！");
           reMap.put("url","/ibook/buyer/user/tologin");
           return new ModelAndView("common/error",reMap);
       }

    }

    /**
     * 用户退出登录
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/logout")
    public ModelAndView logOut(HttpServletRequest request,
                               HttpServletResponse response){
        log.info("用户退出登录：buyerId={}",CookieUtil.get(request,CookieConstrant.BUYER_ID).getValue());
        CookieUtil.delete(response,CookieConstrant.BUYER_ID);
       return new ModelAndView("redirect:"+projectConfig.getIbook()+"/buyer/book/list");
    }


}
