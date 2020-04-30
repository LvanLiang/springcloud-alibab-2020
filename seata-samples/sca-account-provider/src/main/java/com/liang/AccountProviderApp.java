package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 账户服务
 * @author Liangxp
 * @date 2020/4/28 16:01
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AccountProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(AccountProviderApp.class, args);
    }
}
