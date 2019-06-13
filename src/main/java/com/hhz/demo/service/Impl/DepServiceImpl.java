package com.hhz.demo.service.Impl;

import com.hhz.demo.dao.OrganizationDepartmentMapper;
import com.hhz.demo.service.DepService;
import com.uniubi.sdk.model.po.org.OrganizationDepartmentDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepServiceImpl implements DepService {
    private static final Logger logger = LoggerFactory.getLogger(DepServiceImpl.class);

    @Autowired
    private OrganizationDepartmentMapper organizationDepartmentMapper;

    @Override
    public void aaa(String orgId) {
        System.out.println(1111);
        List<OrganizationDepartmentDO> organizationDepartmentDOS = organizationDepartmentMapper.selectDepByOrgId(orgId);
        System.out.println(organizationDepartmentDOS.size());
        System.out.println(22222);
    }
}
