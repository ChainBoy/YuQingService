package com.vrv.nj.domain.req.company;

import com.vrv.nj.domain.req.BaseReq;

public class DeleteReq extends BaseReq
{
    private String organizationCode;
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
}
