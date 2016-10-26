package com.vrv.nj.domain.req.company;

import com.vrv.nj.domain.req.BaseReq;

public class UpdateOrgMsgReq extends BaseReq
{
    private String organizationCode;
    
    private String pretreatment;
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public String getPretreatment()
    {
        return pretreatment;
    }
    
    public void setPretreatment(String pretreatment)
    {
        this.pretreatment = pretreatment;
    }
}
