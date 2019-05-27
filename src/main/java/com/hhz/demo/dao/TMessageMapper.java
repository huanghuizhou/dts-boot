package com.hhz.demo.dao;

import com.hhz.demo.model.TMessage;
import com.hhz.demo.model.TMessageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TMessageMapper {
    int countByExample(TMessageExample example);

    int deleteByExample(TMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TMessage record);

    int insertSelective(TMessage record);

    List<TMessage> selectByExampleWithBLOBs(TMessageExample example);

    List<TMessage> selectByExample(TMessageExample example);

    TMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TMessage record, @Param("example") TMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") TMessage record, @Param("example") TMessageExample example);

    int updateByExample(@Param("record") TMessage record, @Param("example") TMessageExample example);

    int updateByPrimaryKeySelective(TMessage record);

    int updateByPrimaryKeyWithBLOBs(TMessage record);

    int updateByPrimaryKey(TMessage record);
}