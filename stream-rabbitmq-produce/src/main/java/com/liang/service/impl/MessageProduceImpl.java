package com.liang.service.impl;

import com.liang.service.MessageProduce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * Binder  是应用消息中间件之间的封装， 目前实现了 Kafka 和 RabbitMQ 的Binder
 * 通过 Binder 可以很方便的连接中间件，可以动态的改变消息类型（对于Kafka的topic, rabbitmq的exchange）, 这些都可以通过配置文件来实现。
 *
 * Channel 通道，是队列 Queue 的一种抽象，在消息通讯系统中就是实现存储和转发的媒介，通过channel 队列进行配置
 *
 * Source和Sink  简单的理解为参照对象Spring Cloud  Stream 自身，从 Steam 发布消息就是输出，接受消息就是输入
 *
 *
 * 注解@EnableBinding 指信道channel和exchange 绑定在一起。
 * @author Liangxp
 * @date 2020/4/10 16:39
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProduceImpl implements MessageProduce {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send(String message) {
        boolean send = output.send(MessageBuilder.withPayload(message).build());
        log.info("发送结果: {}", send);
        return "ok";
    }
}
