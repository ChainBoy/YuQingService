package com.vrv.nj.domain.resp.company;

import java.util.List;

import com.vrv.nj.domain.mysql.OrganizationMsg;
import com.vrv.nj.domain.resp.BaseResp;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月24日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 加载所有数据
 */
public class LoadAllDataResp extends BaseResp
{
    private List<OrganizationMsg> data;
    
    public List<OrganizationMsg> getData()
    {
        return data;
    }
    
    public void setData(List<OrganizationMsg> data)
    {
        this.data = data;
    }
}
