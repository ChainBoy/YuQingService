package com.vrv.nj.domain.req.info;

import com.vrv.nj.domain.req.BaseReq;

/**
 * 
 * @author 赵炎
 * @version [V1.00, 2016年9月30日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 统计请求
 */
public class SummaryReq extends BaseReq
{
    private String organizationCode;
    
    private String startDate;// yyyy-MM-dd
    
    private String endDate;
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public String getStartDate()
    {
        return startDate;
    }
    
    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }
    
    public String getEndDate()
    {
        return endDate;
    }
    
    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }
    
}
