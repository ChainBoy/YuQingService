package com.vrv.nj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vrv.nj.domain.mysql.DataBean;
import com.vrv.nj.domain.mysql.WebSiteTypeCnt;

/**
 * <一句话功能简述>
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月13日]
 * @see  [相关类/方法]
 * @since V1.00
 */
public interface DataBeanMapper
{
    /**
     * 
     * 根据单位编码查找信息列表
     * 
     * @param organizationCode 单位编码
     * @return
     */
    public List<DataBean> findByOrganizationCode(@Param("organizationCode") String organizationCode);
    
    /**
     * 
     * 插入
     * 
     * @param databean
     */
    public void insertOne(DataBean databean);
    
    /**
     * 
     * 根据发布时间删除帖子
     * 
     * @param poTime 发布时间
     * @see [类、类#方法、类#成员]
     */
    public void deleteByLongTime(long poTime);
    
    /**
     * 
     * 根据单位编码和id查询单条记录
     * 
     * @param organizationCode
     * @param id 帖子id
     */
    public DataBean findByOrganizationAndId(@Param("organizationCode") String organizationCode, @Param("id") String id);
    
    /**
     * 
     * 根据单位编码和id删除一条记录
     * 
     * @param organizationCode 单位编码
     * @param id 帖子id
     */
    public int deleteByOrganizationCodeAndId(@Param("organizationCode") String organizationCode, @Param("id") String id);
    
    /**
     * 
     * 根据id和单位编码更改记录已阅未阅状态
     * 
     * @param organizationCode 单位编码
     * @param id 帖子id
     */
    public void updateByOrgCdeAndId(@Param("organizationCode") String organizationCode, @Param("id") String id);
    
    /**
     * 
     * 根据条件查询
     * 
     * @param map 查询参数
     */
    public List<DataBean> selectByMap(Map<String, Object> map);
    
    /**
     * 
     * 计数
     * 
     * @param map 计数参数
     */
    public int selectByMapCount(Map<String, Object> map);
    
    /**
     * 批量删除帖子
     * 
     * @param organizationCode 单位编码
     * @param ids 帖子id集合
     */
    public void batchDeleteInfo(Map<String, Object> map);
    
    /**
     * 
     * 批量已阅
     * 
     * @param map 查询参数
     */
    public void batchUpdateInfo(Map<String, Object> map);
    
    /** 
     * 根据网站类型分组查询
     * @param map 查询参数
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<WebSiteTypeCnt> selectGroupByWebSiteType(Map<String, Object> map);
}
