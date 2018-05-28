package com.lizhenjie.service;

import com.lizhenjie.dataobject.ProductCategory;

import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 15:48 2018/5/3
 * @Modified By:
 */
public interface CategorySevice {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
