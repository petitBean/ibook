package com.wxz.ibook.from;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 * 添加书籍的
 * @author Wangxingze
 * @date 2019-06-11 16:49
 */
@Data
public class BookForm {
    /**
     * 书名
     */
    private String bookName;

    /**
     * 书店id
     */
    private String  sellerId;
    /**、
     * 书籍描述
     */
    private String  bookDescribe;
    /*
    库存
     */
    private Integer bookStock;
    /**
     * 单价
     */
    private String  bookPriceText;
    /**
     * 出版社名
     */
    private String bookPress;
    /**
     * 作者名
     */
    private String bookAuthor;
    /**
     * 版本
     */
    private String bookEdition;
    /**
     * 出版时间
     */
    private String publicTime;



}
