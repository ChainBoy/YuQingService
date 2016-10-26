package com.vrv.nj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vrv.nj.domain.mysql.MonitorModuleData;

/**
 * 模块数据mapper接口
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月13日]
 * @see  [相关类/方法]
 * @since V1.00
 * @category 模块数据mapper接口
 */
public interface MonitorModuleDataMapper
{
    /** 
     * 单条数据入库
     * @param data
     * @see [类、类#方法、类#成员]
     */
    public void insertOne(MonitorModuleData data);
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param id
     * @param moduleId
     * @return
     * @see [类、类#方法、类#成员]
     */
    public MonitorModuleData selectByPrimaryKey(@Param("id") String id, @Param("moduleId") String moduleId);
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param data
     * @see [类、类#方法、类#成员]
     */
    public void update(MonitorModuleData data);
    
    /** 
     * 根据模块id查询
     * @param moduleId 模块id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<MonitorModuleData> selectByMap(Map<String,Object> map);
    
    /** 
     * 计数
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    public long count(Map<String,Object> map);
    
    /** 
     * 根据long型日期删除之前的数据
     * @param startLongData
     * @see [类、类#方法、类#成员]
     */
    public void deleteBeforeTodayData(long startLongData);
}
