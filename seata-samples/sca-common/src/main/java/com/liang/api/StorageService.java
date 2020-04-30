package com.liang.api;

/**
 * 库存接口
 * @author Liangxp
 * @date 2020/4/29 11:18
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     */
    void decrease(Long productId, Integer count);
}
