package com.liang.controller;

import com.liang.api.AccountService;
import com.liang.domain.Order;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liangxp
 * @date 2020/5/7 11:42
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    private AccountService accountService;

    /**
     * 异常之后，调用accountService就会回滚
     * @param order
     * @return
     */
    @GetMapping("/buy")
    @GlobalTransactional
    public Object buy(Order order) {
        accountService.decrease(order.getUserId(), order.getMoney());
        int num = 10 / 0;
        return "ok";
    }
}
