package com.hhz.demo.service;

import org.springframework.transaction.annotation.Transactional;


/**
 * <p class="detail">
 * 功能:测试 mysql forupdate 锁用
 * </p>
 *
 * @author huangHuizhou
 * @ClassName Dep service.
 * @Version V1.0.
 * @date 2019.06.13 10:31:01
 */
public interface DepService {

    /**
     * <p class="detail">
     * 功能:
     * </p>
     *
     * @param orgId :
     * @author huanghuizhou
     * @date 2019.06.13 10:31:01
     */
    @Transactional
    void aaa(String orgId);
}
