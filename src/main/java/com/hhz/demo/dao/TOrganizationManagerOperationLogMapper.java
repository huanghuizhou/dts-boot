package com.hhz.demo.dao;

import com.hhz.demo.model.TOrganizationManagerOperationLog;
import com.hhz.demo.model.TOrganizationManagerOperationLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TOrganizationManagerOperationLogMapper {

    int countByExample(TOrganizationManagerOperationLogExample example);

    int deleteByExample(TOrganizationManagerOperationLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TOrganizationManagerOperationLog record);

    int insertSelective(TOrganizationManagerOperationLog record);

    List<TOrganizationManagerOperationLog> selectByExampleWithBLOBs(TOrganizationManagerOperationLogExample example);

    List<TOrganizationManagerOperationLog> selectByExample(TOrganizationManagerOperationLogExample example);

    TOrganizationManagerOperationLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TOrganizationManagerOperationLog record, @Param("example") TOrganizationManagerOperationLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TOrganizationManagerOperationLog record, @Param("example") TOrganizationManagerOperationLogExample example);

    int updateByExample(@Param("record") TOrganizationManagerOperationLog record, @Param("example") TOrganizationManagerOperationLogExample example);

    int updateByPrimaryKeySelective(TOrganizationManagerOperationLog record);

    int updateByPrimaryKeyWithBLOBs(TOrganizationManagerOperationLog record);

    int updateByPrimaryKey(TOrganizationManagerOperationLog record);
}