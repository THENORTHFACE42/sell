package com.lizhenjie.dao;

import com.lizhenjie.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 16:28 2018/5/4
 * @Modified By:
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);
}
