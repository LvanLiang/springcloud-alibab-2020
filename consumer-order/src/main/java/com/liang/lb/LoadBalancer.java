package com.liang.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Liangxp
 * @date 2020/3/25 11:48
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
