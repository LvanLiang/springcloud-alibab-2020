package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用consul作为注册中心
 * @author Liangxp
 * @date 2020/3/21 10:03
 */
@SpringBootApplication
public class PaymentConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulApplication.class, args);
    }
}
