package com.liang.mapper;

import com.liang.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Liangxp
 * @date 2020/05/08 22:00
 */
@Mapper
public interface OrderMapper {
    /**
     *  新建订单
     * @param order
     */
    void insert(Order order);

    /**
     * 修改订单状态，从零改为1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
