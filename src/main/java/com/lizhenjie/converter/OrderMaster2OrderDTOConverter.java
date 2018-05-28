package com.lizhenjie.converter;

import com.lizhenjie.dataobject.OrderMaster;
import com.lizhenjie.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhenjie
 * @Description:
 * @Date :Created in 23:26 2018/5/6
 * @Modified By:
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e->
        convert(e)).collect(Collectors.toList());
    }
}
