package com.hhz.demo.mapper;

import com.hhz.demo.model.TEmployee;
import com.hhz.demo.model.TEmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TEmployeeMapper {
    int countByExample(TEmployeeExample example);

    int deleteByExample(TEmployeeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TEmployee record);

    int insertSelective(TEmployee record);

    List<TEmployee> selectByExampleWithBLOBs(TEmployeeExample example);

    List<TEmployee> selectByExample(TEmployeeExample example);

    TEmployee selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TEmployee record, @Param("example") TEmployeeExample example);

    int updateByExampleWithBLOBs(@Param("record") TEmployee record, @Param("example") TEmployeeExample example);

    int updateByExample(@Param("record") TEmployee record, @Param("example") TEmployeeExample example);

    int updateByPrimaryKeySelective(TEmployee record);

    int updateByPrimaryKeyWithBLOBs(TEmployee record);

    int updateByPrimaryKey(TEmployee record);
}