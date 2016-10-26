package com.vrv.nj.domain.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T200_MonitorKey")
public class MonitorKey
{
    
    @Id
    private String id;// ID
    
    private String administrativeId;// 行政区划
    
    private String keyName;// 关键词名
    
    private String keyExpression;// 关键词表达式
    
    private String userId;// 用户ID
    
    private String organizationCode;
    
    private int monitorScope;// 监测范围(0.全国,1.本地)
    
    private int monitorType;
    
    private String[] categoryIds;
    
    private boolean active;// 是否启用
    
    private boolean bImport;// 是否导入
    
    private Date createTime;// 创建时间
    
    private Date updateTime;// 修改时间
    
    // private String MonitorTopicId;//专题ID
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getAdministrativeId()
    {
        return administrativeId;
    }
    
    public void setAdministrativeId(String administrativeId)
    {
        this.administrativeId = administrativeId;
    }
    
    public String getKeyName()
    {
        return keyName;
    }
    
    public void setKeyName(String keyName)
    {
        this.keyName = keyName;
    }
    
    public String getKeyExpression()
    {
        return keyExpression;
    }
    
    public void setKeyExpression(String keyExpression)
    {
        this.keyExpression = keyExpression;
    }
    
    public String getUserId()
    {
        return userId;
    }
    
    public void setUserId(String userId)
    {
        this.userId = userId;
    }
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public int getMonitorScope()
    {
        return monitorScope;
    }
    
    public void setMonitorScope(int monitorScope)
    {
        this.monitorScope = monitorScope;
    }
    
    public int getMonitorType()
    {
        return monitorType;
    }
    
    public void setMonitorType(int monitorType)
    {
        this.monitorType = monitorType;
    }
    
    public String[] getCategoryIds()
    {
        return categoryIds;
    }
    
    public void setCategoryIds(String[] categoryIds)
    {
        this.categoryIds = categoryIds;
    }
    
    public boolean isActive()
    {
        return active;
    }
    
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public boolean isbImport()
    {
        return bImport;
    }
    
    public void setbImport(boolean bImport)
    {
        this.bImport = bImport;
    }
    
}
