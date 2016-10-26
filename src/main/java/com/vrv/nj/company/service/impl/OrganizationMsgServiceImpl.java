package com.vrv.nj.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vrv.nj.company.service.IOrganizaitonMsgService;
import com.vrv.nj.domain.mysql.OrganizationMsg;
import com.vrv.nj.mapper.OrganizationMsgMapper;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年9月30日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 单位信息service
 */
@Service("organizationMsgService")
public class OrganizationMsgServiceImpl implements IOrganizaitonMsgService
{
    @Autowired
    private OrganizationMsgMapper organizationMsgMapper;
    
    @Transactional
    @Override
    public synchronized void save(OrganizationMsg om)
    {
        if (om.getId() == null)
        {
            this.organizationMsgMapper.insertOne(om);
        }
        else
        {
            this.organizationMsgMapper.updateByPrimaryKey(om);
        }
    }
    
    @Override
    public OrganizationMsg findByOrganizationCode(String organizationCode)
    {
        return this.organizationMsgMapper.findByOrganizationCode(organizationCode);
    }
    
    @Override
    public List<OrganizationMsg> findAll()
    {
        return this.organizationMsgMapper.findAll();
    }
    
    @Override
    public List<OrganizationMsg> findAccordOrgs()
    {
        
        return this.organizationMsgMapper.findAccordOrgs();
    }
    
    @Override
    public void deleteOne(String organizationCode)
    {
        this.organizationMsgMapper.deleteByOrgCode(organizationCode);
    }
    
}
