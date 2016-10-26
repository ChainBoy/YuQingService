package com.vrv.nj.domain.mysql;

import java.io.Serializable;

public class BlackList implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -3322223190782414871L;
    
    private String id;
    
    private int active;// 是否启用
    
    private String addTime;// 添加时间
    
    private String updateTime;// 更新时间
    
    private String organizationCode;// 单位编码
    
    private String mainDomain;// 域名
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public int getActive()
    {
        return active;
    }
    
    public void setActive(int active)
    {
        this.active = active;
    }
    
    public String getAddTime()
    {
        return addTime;
    }
    
    public void setAddTime(String addTime)
    {
        this.addTime = addTime;
    }
    
    public String getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public String getMainDomain()
    {
        return mainDomain;
    }
    
    public void setMainDomain(String mainDomain)
    {
        this.mainDomain = mainDomain;
    }
}
