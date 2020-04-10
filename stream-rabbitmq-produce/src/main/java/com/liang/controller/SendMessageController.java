package com.liang.controller;

import com.liang.common.Result;
import com.liang.service.MessageProduce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/4/10 16:44
 */
@Slf4j
@RestController
public class SendMessageController {
    @Resource
    private MessageProduce messageProduce;

    @GetMapping("/send/{msg}")
    public Result sendMessage(@PathVariable String msg) {
        String send = messageProduce.send(msg);
        return new Result<>(200, send);
    }
}
