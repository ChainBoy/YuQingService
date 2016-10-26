package com.vrv.nj.domain.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T200_MonitorBlackList")
public class MonitorBlackList
{
    @Id
    private String id;
    
    private String websiteName; // 网站名
    
    private String websiteUrl; // 网站链接
    
    private int active; // 是否启用 1-启用 0-不启用
    
    private String addTime; // 添加时间
    
    private String updateTime; // 修改时间
    
    private String userId; // 用户id
    
    private String organizationCode; // 单位吗
    
    private String mainDomain; // 主域名
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getWebsiteName()
    {
        return websiteName;
    }
    
    public void setWebsiteName(String websiteName)
    {
        this.websiteName = websiteName;
    }
    
    public String getWebsiteUrl()
    {
        return websiteUrl;
    }
    
    public void setWebsiteUrl(String websiteUrl)
    {
        this.websiteUrl = websiteUrl;
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
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }
    
}
