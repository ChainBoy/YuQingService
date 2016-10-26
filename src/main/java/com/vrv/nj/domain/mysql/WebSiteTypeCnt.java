package com.vrv.nj.domain.mysql;

import java.io.Serializable;

public class WebSiteTypeCnt implements Serializable
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5892245564081195892L;
    
    private int webSiteType;
    
    private long cnt;
    
    public long getCnt()
    {
        return cnt;
    }
    
    public void setCnt(long cnt)
    {
        this.cnt = cnt;
    }
    
    public int getWebSiteType()
    {
        return webSiteType;
    }
    
    public void setWebSiteType(int webSiteType)
    {
        this.webSiteType = webSiteType;
    }
    
}
