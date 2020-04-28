package com.liang.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 账户
 * @author Liangxp
 * @date 2020/4/28 17:11
 */
@Data
public class Account {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
