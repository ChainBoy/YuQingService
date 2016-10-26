package com.vrv.nj.domain.req.blacklist;

import com.vrv.nj.domain.req.BaseReq;

public class BlackListReq extends BaseReq
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
