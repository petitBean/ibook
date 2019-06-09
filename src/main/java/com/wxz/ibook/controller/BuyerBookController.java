package com.wxz.ibook.controller;

import com.wxz.ibook.domain.BookCategory;
import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.service.ServiceImpl.BookInfoServiceImpl;
import com.wxz.ibook.service.ServiceImpl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家端控制器
 * @author Wangxingze
 * @date 2019-06-08 17:05
 */
@Controller
@Slf4j
@RequestMapping("/buyer/book")
public class BuyerBookController {

    @Autowired
    private BookInfoServiceImpl bookInfoService;
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/list")
    public ModelAndView list(){
        Map<String,Object> map=new HashMap<>();
        List<BookInfo> booklist=bookInfoService.findAll();
        List<BookCategory> categoryList=categoryService.findAll();
        map.put("bookList",booklist);
        map.put("categoryList",categoryList);
        return new ModelAndView("book/list",map);
    }

}//controller
