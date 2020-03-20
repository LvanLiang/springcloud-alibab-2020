package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用zookeeper作为注册中心
 * @author Liangxp
 * @date 2020/3/20 10:04
 */
@SpringBootApplication
public class PaymentZkApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZkApplication.class, args);
    }
}
