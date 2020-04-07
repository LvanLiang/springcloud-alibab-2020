package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Liangxp
 * @date 2020/3/20 14:29
 */
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
//@RibbonClient(configuration = MyRibbonRule.class, name = "PAYMENT-SERVICE")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
