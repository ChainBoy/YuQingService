package com.vrv.nj.domain.req.info;

import com.vrv.nj.domain.req.BaseReq;

public class QueryReq extends BaseReq
{
    
    private long startPoTime;
    
    private long endPoTime;
    
    private String organizationCode;
    
    private int currentPage;
    
    private int limit;
    
    private String read;
    
    private int positiveOrNegative;
    
    private String sort;
    
    private String webSiteType;
    
    private String blackList;
    
    public long getStartPoTime()
    {
        return startPoTime;
    }
    
    public void setStartPoTime(long startPoTime)
    {
        this.startPoTime = startPoTime;
    }
    
    public long getEndPoTime()
    {
        return endPoTime;
    }
    
    public void setEndPoTime(long endPoTime)
    {
        this.endPoTime = endPoTime;
    }
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public int getLimit()
    {
        return limit;
    }
    
    public void setLimit(int limit)
    {
        this.limit = limit;
    }
    
    public int getCurrentPage()
    {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }
    
    public String getRead()
    {
        return read;
    }
    
    public void setRead(String read)
    {
        this.read = read;
    }

    public int getPositiveOrNegative()
    {
        return positiveOrNegative;
    }

    public void setPositiveOrNegative(int positiveOrNegative)
    {
        this.positiveOrNegative = positiveOrNegative;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public String getWebSiteType()
    {
        return webSiteType;
    }

    public void setWebSiteType(String webSiteType)
    {
        this.webSiteType = webSiteType;
    }

    public String getBlackList()
    {
        return blackList;
    }

    public void setBlackList(String blackList)
    {
        this.blackList = blackList;
    }
    
}
