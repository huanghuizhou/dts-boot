package com.hhz.demo.dao;

import com.uniubi.sdk.model.po.org.OrganizationDepartmentDO;
import com.uniubi.sdk.mybatis.MybatisMysqlMapper;

import java.util.List;


public interface OrganizationDepartmentMapper extends MybatisMysqlMapper<OrganizationDepartmentDO> {


    /**
     * <p class="detail">
     * 功能:根据 企业id 查询所有部门 for update
     * </p>
     *
     * @param orgId :
     * @return list
     * @author huanghuizhou
     * @date 2019.06.11 09:36:25
     */
    List<OrganizationDepartmentDO> selectDepByOrgId(String orgId);
}