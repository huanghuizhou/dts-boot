package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganizationRole;
import com.hhz.demo.model.TOrganizationRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrganizationRoleMapper {
    int countByExample(TOrganizationRoleExample example);

    int deleteByExample(TOrganizationRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrganizationRole record);

    int insertSelective(TOrganizationRole record);

    List<TOrganizationRole> selectByExample(TOrganizationRoleExample example);

    TOrganizationRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrganizationRole record, @Param("example") TOrganizationRoleExample example);

    int updateByExample(@Param("record") TOrganizationRole record, @Param("example") TOrganizationRoleExample example);

    int updateByPrimaryKeySelective(TOrganizationRole record);

    int updateByPrimaryKey(TOrganizationRole record);
}