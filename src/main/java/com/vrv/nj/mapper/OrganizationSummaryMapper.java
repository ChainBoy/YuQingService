package com.vrv.nj.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.vrv.nj.domain.mysql.OrganizationSummary;

/**
 * 数据汇总mapper
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月13日]
 * @see  [相关类/方法]
 * @since V1.00
 * @category 数据汇总mapper
 */
public interface OrganizationSummaryMapper
{
    /** 
     * 增
     * @param summary
     * @see [类、类#方法、类#成员]
     */
    public void insertOne(OrganizationSummary summary);
    
    /** 
     * 增
     * @param summary
     * @see [类、类#方法、类#成员]
     */
    public void insertSelective(OrganizationSummary summary);
    
    /** 
     * 根据单位编码和日期查询
     * @param organizationCode
     * @param record_time
     * @return
     * @see [类、类#方法、类#成员]
     */
    public OrganizationSummary selectByOrganizationCodeAndTime(@Param("organizationCode") String organizationCode, @Param("record_time") Date record_time);
    
    /** 
     * 根据指定条件查询
     * @param param
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<OrganizationSummary> selectByCondition(Map<String, Object> param);
    
    /** 
     * 改
     * @param summary
     * @see [类、类#方法、类#成员]
     */
    public void updateOne(OrganizationSummary summary);
}
