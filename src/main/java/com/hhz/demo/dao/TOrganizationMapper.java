package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganization;
import com.hhz.demo.model.TOrganizationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrganizationMapper {
    int countByExample(TOrganizationExample example);

    int deleteByExample(TOrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrganization record);

    int insertSelective(TOrganization record);

    List<TOrganization> selectByExample(TOrganizationExample example);

    TOrganization selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrganization record, @Param("example") TOrganizationExample example);

    int updateByExample(@Param("record") TOrganization record, @Param("example") TOrganizationExample example);

    int updateByPrimaryKeySelective(TOrganization record);

    int updateByPrimaryKey(TOrganization record);
}