package com.vrv.nj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.vrv.nj.domain.mysql.OrganizationMsg;

/**
 * 单位信息mapper
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月13日]
 * @see  [相关类/方法]
 * @since V1.00
 * @category 单位信息mapper
 */
public interface OrganizationMsgMapper
{
    /** 
     * 主键删除
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int deleteByPrimaryKey(Integer id);
    
    /** 
     * 单条数据入库
     * @param record
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int insertOne(OrganizationMsg record);
    
    /** 
     * <一句话功能简述>
     * @param record
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int insertSelective(OrganizationMsg record);
    
    /** 
     * <一句话功能简述>
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public OrganizationMsg selectByPrimaryKey(Integer id);
    
    /** 
     * <一句话功能简述>
     * @param record
     * @return
     * @see [类、类#方法、类#成员]
     */
    int updateByPrimaryKeySelective(OrganizationMsg record);
    
    /** 
     * 根据主键更新数据
     * @param record
     * @return
     * @see [类、类#方法、类#成员]
     */
    public int updateByPrimaryKey(OrganizationMsg record);
    
    /** 
     * 单位编码查询
     * @param organizationCode
     * @return
     * @see [类、类#方法、类#成员]
     */
    public OrganizationMsg findByOrganizationCode(String organizationCode);
    
    /** 
     * 查询全部单位信息
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<OrganizationMsg> findAll();
    
    /** 
     * 查询预处理单位信息
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<OrganizationMsg> findAccordOrgs();
    
    public void deleteByOrgCode(@Param("organizationCode")String organizationCode);
}