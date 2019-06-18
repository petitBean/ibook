package com.wxz.ibook.domain;

import com.wxz.ibook.enums.CategoryEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Wangxingze
 * @date 2019-06-07 18:32
 */
@Data
@Entity
public class BookInfo implements Serializable {

    private static final long serialVersionUID = 7323598003689004L;
    /*8
        书籍id
         */
    @Id
    private String  bookId;

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
    private BigDecimal bookPrice;
    /**
     * 出版社名
     */
    private String bookPress;
    /**
     * 作者名
     */
    private String bookAuthor;
    /**
     * 图片连接
     */
    private String bookIcon;

    /**
     * 出版时间
     */
    private String publicTime;

    /**
     * 版本
     */
    private String bookEdition;
    /**
     * 类目编号
     */
    private Integer categoryType= CategoryEnum.OTHERS.getCategoryType();
    //private String create_time;
    //private String update_time;

}
