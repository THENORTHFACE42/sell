package com.lizhenjie.dao;

import com.lizhenjie.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 0:38 2018/5/3
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao dao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=dao.findById(1).get();
        System.out.print(productCategory);
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        dao.save(productCategory);
    }

    @Test
    public void upadateTest(){
        ProductCategory productCategory=dao.findById(2).get();
        productCategory.setCategoryType(4);
        dao.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> result = dao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }


}