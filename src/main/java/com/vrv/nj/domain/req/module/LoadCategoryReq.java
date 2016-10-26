package com.vrv.nj.domain.req.module;

import com.vrv.nj.domain.req.BaseReq;

public class LoadCategoryReq extends BaseReq
{
    private String moduleId;
    
    public String getModuleId()
    {
        return moduleId;
    }
    
    public void setModuleId(String moduleId)
    {
        this.moduleId = moduleId;
    }
    
}