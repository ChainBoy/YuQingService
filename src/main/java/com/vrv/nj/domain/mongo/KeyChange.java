package com.vrv.nj.domain.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.annotation.JSONField;

@Document(collection = "T200_KeyChange")
public class KeyChange
{
    @Id
    private String id;// ID
    
    private String organizationCode;// 单位码（随着userid获得）
    
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;// 修改时间
    
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
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
}
