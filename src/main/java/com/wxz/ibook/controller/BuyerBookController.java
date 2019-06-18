package com.wxz.ibook.controller;

import com.wxz.ibook.config.ProjectConfig;
import com.wxz.ibook.domain.BookCategory;
import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.service.ServiceImpl.BookInfoServiceImpl;
import com.wxz.ibook.service.ServiceImpl.CategoryServiceImpl;
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
    @Autowired
    private ProjectConfig projectConfig;

    @GetMapping("/list")
    public ModelAndView list(){
        Map<String,Object> map=new HashMap<>();
        List<BookInfo> booklist=bookInfoService.findAll();
        List<BookCategory> categoryList=categoryService.findAll();
        map.put("bookList",booklist);
        map.put("categoryList",categoryList);
        return new ModelAndView("book/list",map);
    }

    /**
     * 通过关键字查找图书信息
     * @param bookName
     * @return
     */
    @PostMapping("/searchbybookname")
    public ModelAndView searchByBookName(@RequestParam(value = "bookName",required = false)String bookName){
        Map map=new HashMap();
        if (bookName==null){
            //关键字为空跳转到首页
            map.put("url","/ibook/buyer/book/list");
            map.put("msg","关键字为空");
            return new ModelAndView("commom/scuccess",map);
        }
        List<BookInfo> bookInfoList=bookInfoService.findAllByBookNameLike(bookName);
        if (bookInfoList==null){
            map.put("url","/ibook/buyer/book/list");
            map.put("msg","暂时没有相关信息");
            return new ModelAndView("commom/scuccess",map);
        }
        List<BookCategory> categoryList=categoryService.findAll();
        map.put("bookList",bookInfoList);
        map.put("categoryList",categoryList);
        return new ModelAndView("book/list",map);
    }


    /**
     * 显示所选书籍的信息
     * @param bookId
     * @return
     */
    @GetMapping(value = "/bookdetail")
    public ModelAndView bookDetail(@RequestParam(value = "bookId",required = true)String bookId){
        BookInfo bookInfo=bookInfoService.findOneById(bookId);
        List<BookCategory> categoryList=categoryService.findAll();
        Map<String ,Object> map=new HashMap<>();
        if (bookInfo==null){
            map.put("url","/ibook/buyer/book/list");
            map.put("msg","该书籍可能已下架，信息暂未更新！");
            return new ModelAndView("commom/scuccess",map);
        }
        map.put("categoryList",categoryList);
        map.put("book",bookInfo);
        return new ModelAndView("book/detail",map);
    }

    @GetMapping(value = "/searchbycategory")
    public ModelAndView searchByCategory(@RequestParam(value = "categoryType")Integer categoryType,
                                         Map<String,Object> map){
        List<BookInfo> bookInfoList=bookInfoService.findListByCategoryType(categoryType);
        List<BookCategory> categoryList=categoryService.findAll();
        map.put("bookList",bookInfoList);
        map.put("categoryList",categoryList);
        return new ModelAndView("book/list",map);
    }


}//controller
