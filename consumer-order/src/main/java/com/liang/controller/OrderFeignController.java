package com.liang.controller;

import com.liang.common.Result;
import com.liang.entity.Payment;
import com.liang.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020-04-06 20:37
 */
@Slf4j
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/orderFeign/getById/{id}")
    public Result<Payment> getById(@PathVariable Long id) {
        return paymentFeignService.getById(id);
    }

    @GetMapping("/orderFeign/feignTimeout")
    public Result<String> paymentFeignTimeout() {
        String port = paymentFeignService.paymentFeignTimeout();
        return new Result<>(200, port);
    }
}
