package com.hhz.demo.dao;

import com.hhz.demo.model.TDepartmentApply;
import com.hhz.demo.model.TDepartmentApplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDepartmentApplyMapper {
    int countByExample(TDepartmentApplyExample example);

    int deleteByExample(TDepartmentApplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDepartmentApply record);

    int insertSelective(TDepartmentApply record);

    List<TDepartmentApply> selectByExample(TDepartmentApplyExample example);

    TDepartmentApply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDepartmentApply record, @Param("example") TDepartmentApplyExample example);

    int updateByExample(@Param("record") TDepartmentApply record, @Param("example") TDepartmentApplyExample example);

    int updateByPrimaryKeySelective(TDepartmentApply record);

    int updateByPrimaryKey(TDepartmentApply record);
}