package com.lizhenjie.dao;

import com.lizhenjie.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:24 2018/5/4
 * @Modified By:
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);



}
