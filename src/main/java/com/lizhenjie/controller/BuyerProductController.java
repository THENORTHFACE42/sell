package com.lizhenjie.controller;

import com.lizhenjie.utils.ResultVoUtil;
import com.lizhenjie.vo.ProductInfoVo;
import com.lizhenjie.vo.ProductVo;
import com.lizhenjie.vo.ResultVo;
import com.lizhenjie.dataobject.ProductCategory;
import com.lizhenjie.dataobject.ProductInfo;
import com.lizhenjie.service.CategorySevice;
import com.lizhenjie.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhenjie
 * @Description: 买家商品
 * @Date :Created in 20:39 2018/5/3
 * @Modified By:
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategorySevice categorySevice;

    @GetMapping("list")
    public ResultVo list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList=productService.findUpAll();



        //2.查询类目（一次性查询）
        //java8 lamda表达式
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList= categorySevice.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVo> productVoList=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVo productVo=new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVoList=new ArrayList<>();
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo=new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVoList);
            productVoList.add(productVo);


        }

        return ResultVoUtil.success(productVoList);
    }



}
