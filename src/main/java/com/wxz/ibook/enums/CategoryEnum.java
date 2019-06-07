package com.wxz.ibook.enums;

/*8
基本的书籍类目，其实不应该用enum的
 */
public enum CategoryEnum {

    OTHERS(0,"其他"),
     COMPUTER_SCIENCE(1,"计算机类"),
     LITERATURE(2,"文学类"),
    ;
    private Integer categoryType;
    private String categoryName;

    CategoryEnum(Integer categoryType,String categoryName){
        this.categoryType=categoryType;
        this.categoryName=categoryName;
    }

    public Integer getCategoryType(){
        return categoryType;
    }
    public String getCategoryName(){
        return categoryName;
    }
}
