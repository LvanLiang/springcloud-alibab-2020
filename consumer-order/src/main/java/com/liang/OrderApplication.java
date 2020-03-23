package com.liang;

import com.rule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Liangxp
 * @date 2020/3/20 14:29
 */
@SpringBootApplication
@RibbonClient(configuration = MyRibbonRule.class, name = "PAYMENT-SERVICE")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
