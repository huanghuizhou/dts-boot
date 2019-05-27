package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganizationDepartment;
import com.hhz.demo.model.TOrganizationDepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrganizationDepartmentMapper {
    int countByExample(TOrganizationDepartmentExample example);

    int deleteByExample(TOrganizationDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrganizationDepartment record);

    int insertSelective(TOrganizationDepartment record);

    List<TOrganizationDepartment> selectByExample(TOrganizationDepartmentExample example);

    TOrganizationDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrganizationDepartment record, @Param("example") TOrganizationDepartmentExample example);

    int updateByExample(@Param("record") TOrganizationDepartment record, @Param("example") TOrganizationDepartmentExample example);

    int updateByPrimaryKeySelective(TOrganizationDepartment record);

    int updateByPrimaryKey(TOrganizationDepartment record);
}