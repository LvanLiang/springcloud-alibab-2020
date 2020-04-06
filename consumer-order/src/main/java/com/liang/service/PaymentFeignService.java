package com.liang.service;

import com.liang.common.Result;
import com.liang.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Liangxp
 * @date 2020-04-06 20:38
 */
@Component
@FeignClient("payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/getById/{id}")
    Result<Payment> getById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
