package com.lizhenjie.service.impl;

import com.lizhenjie.dao.ProductInfoDao;
import com.lizhenjie.dataobject.ProductInfo;
import com.lizhenjie.dto.CartDTO;
import com.lizhenjie.enums.ProductStatusEnum;
import com.lizhenjie.enums.ResultEnum;
import com.lizhenjie.exception.SellException;
import com.lizhenjie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 19:54 2018/5/3
 * @Modified By:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=productInfoDao.findById(cartDTO.getProductId()).get();
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result= productInfo.getProductStock()+cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);

        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
           ProductInfo productInfo= productInfoDao.findById(cartDTO.getProductId()).get();
           if(productInfo==null){
               throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
           }
           Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
           if(result<0){
               throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
           }
           productInfo.setProductStock(result);
            productInfoDao.save(productInfo);
        }
    }

    /**
     * 上架
     * @param productId
     * @return
     */

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = productInfoDao.findById(productId).get();
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoDao.save(productInfo);
    }

    /**
     * 下架
     * @param productId
     * @return
     */

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = productInfoDao.findById(productId).get();
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoDao.save(productInfo);
    }
}
