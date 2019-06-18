package com.wxz.ibook.aspect;

import com.wxz.ibook.constrant.CookieConstrant;
import com.wxz.ibook.enums.ExceptionEnum;
import com.wxz.ibook.exception.BuyerAuthorizeException;
import com.wxz.ibook.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Wangxingze
 * @date 2019-06-18 15:08
 */
@Component
@Slf4j
@Aspect
public class BuyerBookCaerAuthorizeAspect {

    @Pointcut("execution(public * com.wxz.ibook.controller.BuyerBookCartController*.*(..))")
    //切入点,排除对用户操作的过滤，因为有登陆等
    public void verify(){
    }

    //通过handler捕获异常
    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();//
        HttpServletRequest request=attributes.getRequest();//获取request
        //查询cookie
        Cookie cookie= CookieUtil.get(request, CookieConstrant.BUYER_ID);
        if (cookie==null) {
            log.warn("【登陆校验】 cookie中查不到用户信息");
            throw new BuyerAuthorizeException(ExceptionEnum.BUYER_AUTHORIZE_COOKIE_NULL);
        }

    }

}
