package com.vrv.nj.info.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vrv.nj.domain.mysql.OrganizationSummary;

/**
 * 网站类型数据汇总
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月13日]
 * @see  [相关类/方法]
 * @since V1.00
 * @category 单位网站类型数据汇总服务
 */
public interface IOrganizationSummaryService
{
    /** 
     * 增
     * @param summary
     * @see [类、类#方法、类#成员]
     */
    public void save(OrganizationSummary summary);
    
    /** 
     * 增
     * @param summary
     * @see [类、类#方法、类#成员]
     */
    public void insertSelective(OrganizationSummary summary);
    
    /** 
     * 根据条件查询
     * @param param
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<OrganizationSummary> findByCondition(Map<String, Object> param);
    
    /** 
     * 根据单位编码和日期查询
     * @param organizationCode
     * @param record_time
     * @return
     * @see [类、类#方法、类#成员]
     */
    public OrganizationSummary findByOrganizationCodeAndTime(@Param("organizationCode") String organizationCode, @Param("record_time") Date record_time);

    /** 
     * 更新
     * @param summary
     * @see [类、类#方法、类#成员]
     */
    public void updateOrganizationSummary(OrganizationSummary summary);
}
