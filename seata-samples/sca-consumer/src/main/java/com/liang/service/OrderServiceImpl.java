package com.liang.service;

import com.liang.api.AccountService;
import com.liang.api.OrderService;
import com.liang.api.StorageService;
import com.liang.domain.Order;
import com.liang.mapper.OrderMapper;
import com.liang.utils.IdUtil;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Liangxp
 * @date 2020/05/06 22:36
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Reference
    private AccountService accountService;

    @Reference
    private StorageService storageService;

    /**
     * 加了注册GlobalTransactional的地方就是TM[事务管理器] 事务的发起方,开始全局事务、提交或回滚全局事务
     * @param order 订单详情
     */
    @Override
    @GlobalTransactional
    public void buy(Order order) {
        // 1.创建订单
        log.info("----->开始新建订单");
        order.setId(IdUtil.getId());
        orderMapper.insert(order);

        // 2.扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        // 3.扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        // 4.修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
    }
}
