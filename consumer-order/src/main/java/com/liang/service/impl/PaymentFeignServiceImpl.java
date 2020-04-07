package com.liang.service.impl;

import com.liang.common.Result;
import com.liang.entity.Payment;
import com.liang.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * 服务降级，一般在客户端，这里统一写所有的降级回调方法
 * @author Liangxp
 * @date 2020/04/07 21:44
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public Result<Payment> getById(Long id) {
        return new Result<>(400, "服务异常了");
    }

    @Override
    public String paymentFeignTimeout() {
        return "服务超时出现异常了！！！";
    }
}
