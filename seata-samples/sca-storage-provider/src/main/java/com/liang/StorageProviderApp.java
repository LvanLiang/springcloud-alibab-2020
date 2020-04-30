package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 库存服务
 * @author Liangxp
 * @date 2020/4/29 12:29
 */
@EnableDiscoveryClient
@SpringBootApplication
public class StorageProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(StorageProviderApp.class, args);
    }
}
