package com.liang.api;

import com.liang.domain.Account;

import java.math.BigDecimal;

/**
 * 账户接口
 * @author Liangxp
 * @date 2020/4/29 11:17
 */
public interface AccountService {
    /**
     * 从账户扣减金额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
