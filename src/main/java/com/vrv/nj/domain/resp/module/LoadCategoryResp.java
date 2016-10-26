package com.vrv.nj.domain.resp.module;

import java.util.List;

import com.vrv.nj.domain.mysql.MonitorModuleData;
import com.vrv.nj.domain.resp.BaseResp;

public class LoadCategoryResp extends BaseResp
{
    private List<MonitorModuleData> data;
    
    private long total;
    
    public long getTotal()
    {
        return total;
    }
    
    public void setTotal(long total)
    {
        this.total = total;
    }
    
    public List<MonitorModuleData> getData()
    {
        return data;
    }
    
    public void setData(List<MonitorModuleData> data)
    {
        this.data = data;
    }
    
}
