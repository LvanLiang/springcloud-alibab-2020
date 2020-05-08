package com.liang.controller;

import com.liang.api.OrderService;
import com.liang.domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/5/7 11:42
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 异常之后，调用accountService就会回滚
     * @param order
     * @return
     */
    @GetMapping("/buy")
    public Object buy(Order order) {
        orderService.buy(order);
        return "ok";
    }
}
