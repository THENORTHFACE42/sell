package com.lizhenjie.service.impl;

import com.lizhenjie.dao.ProductCategoryDao;
import com.lizhenjie.dataobject.ProductCategory;
import com.lizhenjie.service.CategorySevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lizhenjie
 * @Description: 类目
 * @Date :Created in 15:53 2018/5/3
 * @Modified By:
 */
@Service
public class CategoryServiceImpl implements CategorySevice {
    @Autowired
    private ProductCategoryDao productCategoryDao;


    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findById(categoryId).get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}
