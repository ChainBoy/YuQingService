package com.vrv.nj.domain.req.info;

import com.vrv.nj.domain.req.BaseReq;

public class DeleteReq extends BaseReq
{
    private String organizationCode;
    
    private String ids;
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public String getIds()
    {
        return ids;
    }
    
    public void setIds(String ids)
    {
        this.ids = ids;
    }
}
