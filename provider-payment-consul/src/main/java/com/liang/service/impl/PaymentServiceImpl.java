package com.liang.service.impl;

import com.liang.entity.Payment;
import com.liang.mapper.PaymentMapper;
import com.liang.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/3/20 10:26
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int insert(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getById(id);
    }
}
