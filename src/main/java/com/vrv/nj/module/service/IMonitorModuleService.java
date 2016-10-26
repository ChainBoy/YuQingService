package com.vrv.nj.module.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vrv.nj.domain.req.module.LoadCategoryReq;

/**
 * 首页模块数据加载接口
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月12日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 首页模块数据加载接口
 */
@Path("/module")
public interface IMonitorModuleService
{
    /** 
     * 加载首页模块信息
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    @POST
    @Path("/loadcategory")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String loadCategory(LoadCategoryReq req);
}
