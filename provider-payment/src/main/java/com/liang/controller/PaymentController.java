package com.liang.controller;

import com.liang.common.Result;
import com.liang.entity.Payment;
import com.liang.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:{} ", element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/myLb")
    public Result getPaymentLb() {
        return new Result<>(200, port, null);
    }


    /**
     * 测试Feign超时控制
     * @return 端口
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

}
