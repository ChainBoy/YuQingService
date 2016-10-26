package com.vrv.nj.info.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.domain.mysql.OrganizationSummary;
import com.vrv.nj.info.service.IOrganizationSummaryService;
import com.vrv.nj.mapper.OrganizationSummaryMapper;

@Service("organizationSummaryService")
public class OrganizationSummaryServiceImpl implements IOrganizationSummaryService
{
    
    @Autowired
    private OrganizationSummaryMapper organizationSummaryMapper;
    
    @Override
    public void save(OrganizationSummary summary)
    {
        this.organizationSummaryMapper.insertOne(summary);
    }
    
    @Override
    public void insertSelective(OrganizationSummary summary)
    {
        this.organizationSummaryMapper.insertSelective(summary);
    }
    
    @Override
    public List<OrganizationSummary> findByCondition(Map<String, Object> param)
    {
        return this.organizationSummaryMapper.selectByCondition(param);
    }
    
    @Override
    public OrganizationSummary findByOrganizationCodeAndTime(String organizationCode, Date record_time)
    {
        return this.organizationSummaryMapper.selectByOrganizationCodeAndTime(organizationCode, record_time);
    }
    
    @Override
    public void updateOrganizationSummary(OrganizationSummary summary)
    {
        this.organizationSummaryMapper.updateOne(summary);
    }
    
}
