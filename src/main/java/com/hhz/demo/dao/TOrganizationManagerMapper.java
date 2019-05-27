package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganizationManager;
import com.hhz.demo.model.TOrganizationManagerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrganizationManagerMapper {
    int countByExample(TOrganizationManagerExample example);

    int deleteByExample(TOrganizationManagerExample example);

    int deleteByPrimaryKey(@Param("employeeId") Long employeeId, @Param("organizationId") Long organizationId);

    int insert(TOrganizationManager record);

    int insertSelective(TOrganizationManager record);

    List<TOrganizationManager> selectByExampleWithBLOBs(TOrganizationManagerExample example);

    List<TOrganizationManager> selectByExample(TOrganizationManagerExample example);

    TOrganizationManager selectByPrimaryKey(@Param("employeeId") Long employeeId, @Param("organizationId") Long organizationId);

    int updateByExampleSelective(@Param("record") TOrganizationManager record, @Param("example") TOrganizationManagerExample example);

    int updateByExampleWithBLOBs(@Param("record") TOrganizationManager record, @Param("example") TOrganizationManagerExample example);

    int updateByExample(@Param("record") TOrganizationManager record, @Param("example") TOrganizationManagerExample example);

    int updateByPrimaryKeySelective(TOrganizationManager record);

    int updateByPrimaryKeyWithBLOBs(TOrganizationManager record);

    int updateByPrimaryKey(TOrganizationManager record);
}