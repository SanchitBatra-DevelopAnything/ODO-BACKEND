package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Order.OrderDTO;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    void insertOrder(@Param("orderId") String orderId,@Param("order")OrderDTO order);
}
