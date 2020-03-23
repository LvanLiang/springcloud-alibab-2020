package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 替换默认的轮询规则为随机
 * @author Liangxp
 * @date 2020/3/23 10:46
 */
@Configuration
public class MyRibbonRule {
    @Bean
    public IRule myRule(){
        // 定义为随机
        return new RandomRule();
    }
}
