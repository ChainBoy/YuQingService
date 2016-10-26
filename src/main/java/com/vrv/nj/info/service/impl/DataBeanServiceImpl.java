package com.vrv.nj.info.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vrv.nj.domain.mysql.DataBean;
import com.vrv.nj.domain.mysql.WebSiteTypeCnt;
import com.vrv.nj.info.service.IDataBeanService;
import com.vrv.nj.mapper.DataBeanMapper;

/**
 * <一句话功能简述>
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月6日]
 * @see  [相关类/方法]
 * @since V1.00
 */
@Service("dataBeanService")
public class DataBeanServiceImpl implements IDataBeanService
{
    @Autowired
    private DataBeanMapper dataBeanMapper;
    
    @Override
    public List<DataBean> findByOrganizationCode(String organizationCode)
    {
        return this.dataBeanMapper.findByOrganizationCode(organizationCode);
    }
    
    @Override
    @Transactional
    public void insert(DataBean databean)
    {
        this.dataBeanMapper.insertOne(databean);
    }
    
    @Override
    public void deleteByLongTime(long time)
    {
        
        this.dataBeanMapper.deleteByLongTime(time);
    }
    
    @Override
    public DataBean findByCondition(String organizationCode, String id)
    {
        return this.dataBeanMapper.findByOrganizationAndId(organizationCode, id);
    }
    
    @Override
    @Transactional
    public int deleteByOrganizationAndId(String organizationCode, String id)
    {
        return this.dataBeanMapper.deleteByOrganizationCodeAndId(organizationCode, id);
        
    }
    
    @Override
    @Transactional
    public void tipRead(String organizationCode, String id)
    {
        this.dataBeanMapper.updateByOrgCdeAndId(organizationCode, id);
    }
    
    @Override
    public List<DataBean> findByMap(Map<String, Object> map)
    {
        return this.dataBeanMapper.selectByMap(map);
    }
    
    @Override
    public int findByMapCount(Map<String, Object> map)
    {
        return this.dataBeanMapper.selectByMapCount(map);
    }
    
    @Override
    @Transactional
    public void batchDeleteInfo(Map<String, Object> map)
    {
        this.dataBeanMapper.batchDeleteInfo(map);
    }
    
    @Override
    @Transactional
    public void batchUpdateInfo(Map<String, Object> map)
    {
        this.dataBeanMapper.batchUpdateInfo(map);
    }
    
    @Override
    public List<WebSiteTypeCnt> summaryByOrganization(Map<String, Object> map)
    {
        return this.dataBeanMapper.selectGroupByWebSiteType(map);
    }
    
}
