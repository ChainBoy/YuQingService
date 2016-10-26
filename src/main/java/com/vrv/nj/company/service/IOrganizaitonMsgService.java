package com.vrv.nj.company.service;

import java.util.List;

import com.vrv.nj.domain.mysql.OrganizationMsg;

/**
 * 单位信息service接口
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年9月30日]
 * @see  [相关类/方法]
 * @since V1.00
 * @category 单位信息service接口
 */
public interface IOrganizaitonMsgService
{
    public void save(OrganizationMsg om);
    
    public OrganizationMsg findByOrganizationCode(String organizationCode);
    
    public List<OrganizationMsg> findAll();
    
    public List<OrganizationMsg> findAccordOrgs();
    
    public void deleteOne(String organizationCode);
    
}
