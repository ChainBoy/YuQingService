package com.vrv.nj.module.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vrv.nj.domain.mysql.MonitorModuleData;
import com.vrv.nj.mapper.MonitorModuleDataMapper;
import com.vrv.nj.module.service.IMonitorModuleDataService;

/**
 * 首页模块数据服务
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月12日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 数据加载服务
 */
@Service("monitorModuleDataService")
public class MonitorModuleDataServiceImpl implements IMonitorModuleDataService
{
    @Autowired
    private MonitorModuleDataMapper monitorModuleDataMapper;
    
    @Transactional
    @Override
    public void save(MonitorModuleData data)
    {
        this.monitorModuleDataMapper.insertOne(data);
        
    }
    
    @Override
    public MonitorModuleData findByPK(String id, String moduleId)
    {
        return this.monitorModuleDataMapper.selectByPrimaryKey(id, moduleId);
    }
    @Transactional
    @Override
    public void update(MonitorModuleData data)
    {
        this.monitorModuleDataMapper.update(data);
    }
    
    @Override
    public List<MonitorModuleData> findByModuleId(Map<String, Object> map)
    {
        return this.monitorModuleDataMapper.selectByMap(map);
    }
    
    @Override
    public long count(Map<String, Object> map)
    {
        return this.monitorModuleDataMapper.count(map);
    }
    @Transactional
    @Override
    public void deleteBeforeTodayData(long startLongDate)
    {
        this.monitorModuleDataMapper.deleteBeforeTodayData(startLongDate);
    }
    
}
