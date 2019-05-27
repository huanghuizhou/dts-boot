package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganizationDismissionEmployee;
import com.hhz.demo.model.TOrganizationDismissionEmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrganizationDismissionEmployeeMapper {
    int countByExample(TOrganizationDismissionEmployeeExample example);

    int deleteByExample(TOrganizationDismissionEmployeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrganizationDismissionEmployee record);

    int insertSelective(TOrganizationDismissionEmployee record);

    List<TOrganizationDismissionEmployee> selectByExample(TOrganizationDismissionEmployeeExample example);

    TOrganizationDismissionEmployee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrganizationDismissionEmployee record, @Param("example") TOrganizationDismissionEmployeeExample example);

    int updateByExample(@Param("record") TOrganizationDismissionEmployee record, @Param("example") TOrganizationDismissionEmployeeExample example);

    int updateByPrimaryKeySelective(TOrganizationDismissionEmployee record);

    int updateByPrimaryKey(TOrganizationDismissionEmployee record);
}