package com.wxz.ibook.DataTransObject;

import com.wxz.ibook.domain.BookInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * 购物车，记录一个商品
 * @author Wangxingze
 * @date 2019-06-17 14:54
 */
@Data
public class BookCart implements Serializable {

    private static final long serialVersionUID = 9187499322837758212L;

    private Integer bookNum;

    private BookInfo bookInfo;

    public BookCart(Integer bookNum,BookInfo bookInfo){
        this.bookNum=bookNum;
        this.bookInfo=bookInfo;
    }

}
