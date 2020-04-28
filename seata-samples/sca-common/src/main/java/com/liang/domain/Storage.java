package com.liang.domain;

import lombok.Data;

/**
 * 库存
 * @author Liangxp
 * @date 2020/4/28 17:09
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
