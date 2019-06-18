package com.wxz.ibook.controller;

import com.wxz.ibook.config.ProjectConfig;
import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.enums.ExceptionEnum;
import com.wxz.ibook.exception.IbookException;
import com.wxz.ibook.from.BookForm;
import com.wxz.ibook.message.Message;
import com.wxz.ibook.service.ServiceImpl.BookInfoServiceImpl;
import com.wxz.ibook.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

/**
 * @author Wangxingze
 * @date 2019-06-18 11:33
 */
@Controller
@RequestMapping("/seller/book")
@Slf4j
public class SellerBookController {
    @Autowired
    private BookInfoServiceImpl bookInfoService;

    @Autowired
    private ProjectConfig projectConfig;
    /**
     * 跳转至填写图书信息的页面
     * @return
     */
    @GetMapping(value = "/create")
    public ModelAndView createBook(){
        return new ModelAndView("seller/book/createbook");
    }

    /**
     * 提交并保存图书信息
     * @param bookForm
     * @param bookIcon
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping(value = "/save")
    public ModelAndView save(@Valid BookForm bookForm,
                             @RequestParam("bookIcon") MultipartFile bookIcon,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        BigDecimal bookPrice;
        //检查价格转换
        try{
             bookPrice=BigDecimal.valueOf((Double.parseDouble(bookForm.getBookPriceText())));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            map.put("msg","单价数据格式错误");
            map.put("url","/ibook/seller/book/create");
            return new ModelAndView("common/error",map);
        }

        if(bindingResult.hasErrors()){
             map.put("msg",bindingResult.getFieldError().getDefaultMessage());
             map.put("url","/ibook/seller/book/create");
             return new ModelAndView("common/error",map);
        }
        BookInfo bookInfo=new BookInfo();
        BeanUtils.copyProperties(bookForm,bookInfo);
        //
        bookInfo.setBookPrice(bookPrice);
        //TODO 需要动态获取sellerId
        //上传图片
        //获取文件名
        String fileName=bookIcon.getOriginalFilename();
        //获取文件后缀名
        String suffixName =fileName.substring(fileName.lastIndexOf('.'));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //设置图片路径到bookinfo
        //指定本地文件夹存储图片
        String filePath = projectConfig.getBookImageSavePath();
        try {
            //将图片保存到static文件夹里
            bookIcon.transferTo(new File(filePath+fileName));

        } catch (Exception e) {
            e.printStackTrace();
            log.error("【上传书籍】图片上传失败！ sellerId={}",bookInfo.getSellerId());
            map.put("msg","图片上传失败");
            map.put("url","/ibook/seller/book/create");
            return new ModelAndView("common/error",map);
        }
        //设置id
        bookInfo.setBookId(KeyUtil.getUniqueKey());

        bookInfo.setBookIcon("/ibook/photo/books/"+fileName);
        //保存
       BookInfo result= bookInfoService.save(bookInfo);
       if (result==null){
           log.error("【上传书籍】书籍保存失败！ sellerId={}，BookId={}，fileName={}",bookInfo.getSellerId(),bookInfo.getBookId(),fileName);
           map.put("msg","书籍保存失败");
           map.put("url","/ibook/seller/book/create");
           return new ModelAndView("common/error",map);
       }
        log.info("【上传书籍】书籍保存成功！ sellerId={}，BookId={}",bookInfo.getSellerId(),bookInfo.getBookId());
        map.put("msg","书籍保存成功");
        map.put("url","/ibook/seller/book/create");
        return new ModelAndView("common/success",map);
    }

}
