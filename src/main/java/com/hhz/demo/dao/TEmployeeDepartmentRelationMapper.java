package com.hhz.demo.dao;

import com.hhz.demo.model.TEmployeeDepartmentRelation;
import com.hhz.demo.model.TEmployeeDepartmentRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEmployeeDepartmentRelationMapper {
    int countByExample(TEmployeeDepartmentRelationExample example);

    int deleteByExample(TEmployeeDepartmentRelationExample example);

    int deleteByPrimaryKey(@Param("departmentId") Long departmentId, @Param("employeeId") Long employeeId);

    int insert(TEmployeeDepartmentRelation record);

    int insertSelective(TEmployeeDepartmentRelation record);

    List<TEmployeeDepartmentRelation> selectByExample(TEmployeeDepartmentRelationExample example);

    TEmployeeDepartmentRelation selectByPrimaryKey(@Param("departmentId") Long departmentId, @Param("employeeId") Long employeeId);

    int updateByExampleSelective(@Param("record") TEmployeeDepartmentRelation record, @Param("example") TEmployeeDepartmentRelationExample example);

    int updateByExample(@Param("record") TEmployeeDepartmentRelation record, @Param("example") TEmployeeDepartmentRelationExample example);

    int updateByPrimaryKeySelective(TEmployeeDepartmentRelation record);

    int updateByPrimaryKey(TEmployeeDepartmentRelation record);
}