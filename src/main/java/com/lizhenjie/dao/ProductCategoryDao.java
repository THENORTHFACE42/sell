package com.lizhenjie.dao;

import com.lizhenjie.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 0:27 2018/5/3
 * @Modified By:
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
