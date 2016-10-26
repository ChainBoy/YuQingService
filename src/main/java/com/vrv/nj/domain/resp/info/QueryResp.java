package com.vrv.nj.domain.resp.info;

import java.util.List;

import com.vrv.nj.domain.mysql.DataBean;
import com.vrv.nj.domain.resp.BaseResp;

public class QueryResp extends BaseResp
{
    private List<DataBean> data;
    
    private int pageNo;
    
    private int limit;
    
    private int total;
    
    private int totalPage;
    
    public List<DataBean> getData()
    {
        return data;
    }
    
    public void setData(List<DataBean> data)
    {
        this.data = data;
    }
    
    public int getPageNo()
    {
        return pageNo;
    }
    
    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }
    
    public int getLimit()
    {
        return limit;
    }
    
    public void setLimit(int limit)
    {
        this.limit = limit;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public int getTotalPage()
    {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }
}
