package com.liang.controller;

import com.liang.common.Result;
import com.liang.entity.Payment;
import com.liang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/3/20 10:24
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/insert")
    public Result insert(@RequestBody Payment payment) {
        log.info(">>>>>>>支付开始插入{}", payment);
        int result = paymentService.insert(payment);
        if (result > 0) {
            return new Result<>(200, "插入成功", null);
        } else {
            return new Result<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "/getById/{id}")
    public Result<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info(">>>>>>>支付查询{}", id);
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new Result<>(200, "查询成功,端口:" + port, payment);
        } else {
            return new Result<>(444, "没有对应记录,查询ID: " + id, null);
        }
    }
}
