package com.liang.mapper;

import com.liang.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Liangxp
 * @date 2020/3/20 10:39
 */
@Mapper
public interface PaymentMapper {
    int insert(Payment payment);

    Payment getById(Long id);
}
