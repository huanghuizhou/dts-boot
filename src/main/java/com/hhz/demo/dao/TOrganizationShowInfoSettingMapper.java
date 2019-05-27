package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganizationShowInfoSetting;
import com.hhz.demo.model.TOrganizationShowInfoSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TOrganizationShowInfoSettingMapper {
    int countByExample(TOrganizationShowInfoSettingExample example);

    int deleteByExample(TOrganizationShowInfoSettingExample example);

    int deleteByPrimaryKey(@Param("departmentId") Long departmentId, @Param("modifyTime") Date modifyTime);

    int insert(TOrganizationShowInfoSetting record);

    int insertSelective(TOrganizationShowInfoSetting record);

    List<TOrganizationShowInfoSetting> selectByExampleWithBLOBs(TOrganizationShowInfoSettingExample example);

    List<TOrganizationShowInfoSetting> selectByExample(TOrganizationShowInfoSettingExample example);

    TOrganizationShowInfoSetting selectByPrimaryKey(@Param("departmentId") Long departmentId, @Param("modifyTime") Date modifyTime);

    int updateByExampleSelective(@Param("record") TOrganizationShowInfoSetting record, @Param("example") TOrganizationShowInfoSettingExample example);

    int updateByExampleWithBLOBs(@Param("record") TOrganizationShowInfoSetting record, @Param("example") TOrganizationShowInfoSettingExample example);

    int updateByExample(@Param("record") TOrganizationShowInfoSetting record, @Param("example") TOrganizationShowInfoSettingExample example);

    int updateByPrimaryKeySelective(TOrganizationShowInfoSetting record);

    int updateByPrimaryKeyWithBLOBs(TOrganizationShowInfoSetting record);

    int updateByPrimaryKey(TOrganizationShowInfoSetting record);
}