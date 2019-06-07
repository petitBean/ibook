package com.wxz.ibook.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Wangxingze
 * @date 2019-06-07 21:32
 * 书籍类目
 */
@Entity
@Data
public class BookCategory {
    /**
     * 类目id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * 类目名称
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer  categoryType;
}
