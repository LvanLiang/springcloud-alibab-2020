package com.liang.service;

import com.liang.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Liangxp
 * @date 2020/3/20 10:26
 */
public interface PaymentService {
    int insert(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
