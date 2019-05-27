package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganizationRoleGroup;
import com.hhz.demo.model.TOrganizationRoleGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrganizationRoleGroupMapper {
    int countByExample(TOrganizationRoleGroupExample example);

    int deleteByExample(TOrganizationRoleGroupExample example);

    int deleteByPrimaryKey(Long roleGroupId);

    int insert(TOrganizationRoleGroup record);

    int insertSelective(TOrganizationRoleGroup record);

    List<TOrganizationRoleGroup> selectByExample(TOrganizationRoleGroupExample example);

    TOrganizationRoleGroup selectByPrimaryKey(Long roleGroupId);

    int updateByExampleSelective(@Param("record") TOrganizationRoleGroup record, @Param("example") TOrganizationRoleGroupExample example);

    int updateByExample(@Param("record") TOrganizationRoleGroup record, @Param("example") TOrganizationRoleGroupExample example);

    int updateByPrimaryKeySelective(TOrganizationRoleGroup record);

    int updateByPrimaryKey(TOrganizationRoleGroup record);
}