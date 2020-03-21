package com.liang.controller;

import com.liang.common.Result;
import com.liang.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/3/20 15:22
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    public static final String PAYMENT_URL = "http://payment-service-zk";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getById/{id}")
    public Result<Payment> getById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL.concat("/payment/getById/") + id, Result.class);
    }
}
