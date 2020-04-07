package com.liang.controller;

import com.liang.common.Result;
import com.liang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/4/7 16:31
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/ok/{id}")
    public Result paymentOk(@PathVariable Long id) {
        String paymentOk = paymentService.paymentOk(id);
        log.info("*****paymentOk: "+paymentOk);
        return new Result<>(200, paymentOk);
    }

    @GetMapping("/timeout/{id}")
    public Result paymentTimeout(@PathVariable Long id) {
        String paymentTimeout = paymentService.paymentTimeout(id);
        log.info("*****paymentTimeout: "+paymentTimeout);
        return new Result<>(200, paymentTimeout);
    }

}
