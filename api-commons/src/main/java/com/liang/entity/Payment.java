package com.liang.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单支付
 * @author Liangxp
 * @date 2020/3/20 9:51
 */
@Data
public class Payment implements Serializable {
    private static final long serialVersionUID = 8257675687678389387L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 订单号
     */
    private String serial;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;
}
