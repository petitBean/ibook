package com.wxz.ibook.handler;

import com.wxz.ibook.exception.BuyerAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangxingze
 * @date 2019-06-18 15:38
 */
@ControllerAdvice
public class IbookBuyerExceptionHandler {

    //捕获BuyerAuthorizeException异常
    @ExceptionHandler(value = BuyerAuthorizeException.class)
    public ModelAndView AuthorizeException(){
        Map<String,Object> map=new HashMap<>();
        map.put("url","/ibook/buyer/user/tologin");
        map.put("msg","你还未登陆！");
        return new ModelAndView("common/error",map);
    }

}
