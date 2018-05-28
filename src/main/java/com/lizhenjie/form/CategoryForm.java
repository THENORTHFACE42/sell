package com.lizhenjie.form;

import lombok.Data;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 23:31 2018/5/10
 * @Modified By:
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
