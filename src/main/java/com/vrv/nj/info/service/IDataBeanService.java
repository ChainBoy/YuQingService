package com.vrv.nj.info.service;

import java.util.List;
import java.util.Map;

import com.vrv.nj.domain.mysql.DataBean;
import com.vrv.nj.domain.mysql.WebSiteTypeCnt;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月6日]
 * @see [相关类/方法]
 * @since V1.00
 */
public interface IDataBeanService
{
    /**
     * 根据单位码查询数据
     * 
     * @param organizationCode
     * @return
     */
    public List<DataBean> findByOrganizationCode(String organizationCode);
    
    /**
     * 插入一条数据
     * 
     * @param databean
     */
    public void insert(DataBean databean);
    
    /**
     * 根据时间删除数据
     * 
     * @param time
     */
    public void deleteByLongTime(long time);
    
    /**
     * 根据id和单位编码查询
     * 
     * @param organizationCode
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public DataBean findByCondition(String organizationCode, String id);
    
    /**
     * 删除数据
     * 
     * @param organizationCode
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int deleteByOrganizationAndId(String organizationCode, String id);
    
    /**
     * 标记已阅
     * 
     * @param organizationCode
     * @param id
     * @see [类、类#方法、类#成员]
     */
    public void tipRead(String organizationCode, String id);
    
    /**
     * 多条件查询
     * 
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<DataBean> findByMap(Map<String, Object> map);
    
    /**
     * 多条件查询计数
     * 
     * @param map
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int findByMapCount(Map<String, Object> map);
    
    /**
     * 批量删除
     * 
     * @param map
     * @see [类、类#方法、类#成员]
     */
    public void batchDeleteInfo(Map<String, Object> map);
    
    /**
     * 批量更新
     * 
     * @param map
     * @see [类、类#方法、类#成员]
     */
    public void batchUpdateInfo(Map<String, Object> map);
    
    public List<WebSiteTypeCnt> summaryByOrganization(Map<String, Object> map);
    
}
