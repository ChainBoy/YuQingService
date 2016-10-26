package com.vrv.nj.module.service;

import java.util.List;
import java.util.Map;

import com.vrv.nj.domain.mysql.MonitorModuleData;

/**
 * 数据加载mapper接口
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月12日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 数据加载mapper接口
 */
public interface IMonitorModuleDataService
{
    /**
     * 单条数据保存
     * 
     * @param data
     * @see [类、类#方法、类#成员]
     */
    public void save(MonitorModuleData data);
    
    /**
     * 更新数据
     * 
     * @param data
     * @see [类、类#方法、类#成员]
     */
    public void update(MonitorModuleData data);
    
    /**
     * 根据帖子id和模块id查询
     * 
     * @param id 帖子id
     * @param moduleId 模块id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public MonitorModuleData findByPK(String id, String moduleId);
    
    /**
     * 根据模块id查询所有数据 查询最新10条数据
     * 
     * @param moduleId 模块id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<MonitorModuleData> findByModuleId(Map<String,Object> map);
    
    /**
     * 根据条件查询总数
     * 
     * @param paraMap 计数的查询参数
     * @return
     * @see [类、类#方法、类#成员]
     */
    public long count(Map<String, Object> paraMap);
    
    /**
     * 删除今天之前的所有信息
     * 
     * @param startLongDate 当前日期的开始long型日期
     * @see [类、类#方法、类#成员]
     */
    public void deleteBeforeTodayData(long startLongDate);
    
}
