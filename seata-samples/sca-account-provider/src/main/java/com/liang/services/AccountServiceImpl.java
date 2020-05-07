package com.liang.services;

import com.liang.api.AccountService;
import com.liang.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Liangxp
 * @date 2020/4/29 11:38
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        accountMapper.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
