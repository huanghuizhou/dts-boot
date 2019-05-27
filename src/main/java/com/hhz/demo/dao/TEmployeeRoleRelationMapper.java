package com.hhz.demo.dao;

import com.hhz.demo.model.TEmployeeRoleRelation;
import com.hhz.demo.model.TEmployeeRoleRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEmployeeRoleRelationMapper {
    int countByExample(TEmployeeRoleRelationExample example);

    int deleteByExample(TEmployeeRoleRelationExample example);

    int deleteByPrimaryKey(@Param("employeeId") Long employeeId, @Param("roleId") Long roleId);

    int insert(TEmployeeRoleRelation record);

    int insertSelective(TEmployeeRoleRelation record);

    List<TEmployeeRoleRelation> selectByExampleWithBLOBs(TEmployeeRoleRelationExample example);

    List<TEmployeeRoleRelation> selectByExample(TEmployeeRoleRelationExample example);

    TEmployeeRoleRelation selectByPrimaryKey(@Param("employeeId") Long employeeId, @Param("roleId") Long roleId);

    int updateByExampleSelective(@Param("record") TEmployeeRoleRelation record, @Param("example") TEmployeeRoleRelationExample example);

    int updateByExampleWithBLOBs(@Param("record") TEmployeeRoleRelation record, @Param("example") TEmployeeRoleRelationExample example);

    int updateByExample(@Param("record") TEmployeeRoleRelation record, @Param("example") TEmployeeRoleRelationExample example);

    int updateByPrimaryKeySelective(TEmployeeRoleRelation record);

    int updateByPrimaryKeyWithBLOBs(TEmployeeRoleRelation record);
}