package com.wxz.ibook.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wangxingze
 * @date 2019-06-07 15:03
 */
@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping("/test")
    public String hello(){
        return "HELLO";
    }
}
