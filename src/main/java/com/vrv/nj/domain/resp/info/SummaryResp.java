package com.vrv.nj.domain.resp.info;

import java.util.List;

import com.vrv.nj.domain.mysql.WebSiteTypeCnt;
import com.vrv.nj.domain.resp.BaseResp;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年9月30日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 统计返回
 */
public class SummaryResp extends BaseResp
{
    private List<WebSiteTypeCnt> summary;
    
    public List<WebSiteTypeCnt> getSummary()
    {
        return summary;
    }
    
    public void setSummary(List<WebSiteTypeCnt> summary)
    {
        this.summary = summary;
    }
    
}
