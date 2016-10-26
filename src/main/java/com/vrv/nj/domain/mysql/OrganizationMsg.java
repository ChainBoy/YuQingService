package com.vrv.nj.domain.mysql;

import java.io.Serializable;
import java.util.Date;

public class OrganizationMsg implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
    
    private String organizationcode;
    
    private String organizationname;
    
    private Date updatetime;
    
    private Date lastQueryTime;
    
    private String subcategory;
    
    private String version;
    
    private String search_version;
    
    private String source;
    // 0 未加入 1：已加入
    private int pretreatment;
    
    private int queue_status;
    
    public Integer getId()
    {
        return id;
    }
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    
    public String getOrganizationcode()
    {
        return organizationcode;
    }
    
    public void setOrganizationcode(String organizationcode)
    {
        this.organizationcode = organizationcode == null ? null : organizationcode.trim();
    }
    
    public String getOrganizationname()
    {
        return organizationname;
    }
    
    public void setOrganizationname(String organizationname)
    {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }
    
    public Date getUpdatetime()
    {
        return updatetime;
    }
    
    public void setUpdatetime(Date updatetime)
    {
        this.updatetime = updatetime;
    }
    
    public String getSubcategory()
    {
        return subcategory;
    }
    
    public void setSubcategory(String subcategory)
    {
        this.subcategory = subcategory == null ? null : subcategory.trim();
    }
    
    public Date getLastQueryTime()
    {
        return lastQueryTime;
    }
    
    public void setLastQueryTime(Date lastQueryTime)
    {
        this.lastQueryTime = lastQueryTime;
    }
    
    public String getVersion()
    {
        return version;
    }
    
    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getSearch_version()
    {
        return search_version;
    }

    public void setSearch_version(String search_version)
    {
        this.search_version = search_version;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public int getPretreatment()
    {
        return pretreatment;
    }

    public void setPretreatment(int pretreatment)
    {
        this.pretreatment = pretreatment;
    }

    public int getQueue_status()
    {
        return queue_status;
    }

    public void setQueue_status(int queue_status)
    {
        this.queue_status = queue_status;
    }
    
}