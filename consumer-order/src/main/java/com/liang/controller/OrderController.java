package com.liang.controller;

import com.liang.common.Result;
import com.liang.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getById/{id}")
    public Result<Payment> getById(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL.concat("/payment/getById/") + id, Result.class);
    }

    /**
     * 测试 RestTemplate的getForEntity方法
     * @param id 支付id
     * @return 支付详情
     */
    @GetMapping("/getByIdForEntity/{id}")
    public Result<Payment> getByIdForEntity(@PathVariable Long id){
        ResponseEntity<Result> entity = restTemplate.getForEntity(PAYMENT_URL.concat("/payment/getById/") + id, Result.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new Result<>(444, "操作失败");
        }
    }

    /**
     * 测试 RestTemplate的postForObject方法
     * @param payment 支付订单
     * @return 操作结果
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL.concat("/payment/insert"), payment, Result.class);
    }
}
