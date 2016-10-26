package com.vrv.nj.domain.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * 日志类
 *
 */
@Document(collection = "T200_BaseLog")
public class BaseLog
{
    
    @Id
    private String id;
    
    private String organizationCode;
    
    private String username;
    
    private String accessIp;
    
    private String accessIpArea;
    
    private String command;
    
    private Date createTime = new Date();
    
    private Date updateTime;
    
    private String userRight;
    
    private String remark;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getAccessIp()
    {
        return accessIp;
    }
    
    public void setAccessIp(String accessIp)
    {
        this.accessIp = accessIp;
    }
    
    public String getAccessIpArea()
    {
        return accessIpArea;
    }
    
    public void setAccessIpArea(String accessIpArea)
    {
        this.accessIpArea = accessIpArea;
    }
    
    public String getCommand()
    {
        return command;
    }
    
    public void setCommand(String command)
    {
        this.command = command;
    }
    
    public String getRemark()
    {
        return remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
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
    
    public String getUserRight()
    {
        return userRight;
    }
    
    public void setUserRight(String userRight)
    {
        this.userRight = userRight;
    }
}
