package com.vrv.nj.info.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vrv.nj.domain.req.info.DeleteReq;
import com.vrv.nj.domain.req.info.QueryReq;
import com.vrv.nj.domain.req.info.SummaryReq;
import com.vrv.nj.domain.req.info.TipReadReq;

/**
 * 信息模块数据服务
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月12日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 信息模块数据服务
 */
public interface IShowInfoService
{
    /**
     * 
     * 标记已阅
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    @POST
    @Path("/read")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String tipRead(TipReadReq req);
    
    /**
     * 数据查询接口
     * 
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    @POST
    @Path("/query")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String query(QueryReq req);
    
    /**
     * 批量删除接口
     * 
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    @POST
    @Path("/delete")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String delete(DeleteReq req);
    
    /**
     * 统计接口
     * 
     * @param req
     * @return
     * @see [类、类#方法、类#成员]
     */
    @POST
    @Path("/summary")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String summary(SummaryReq req);
    
}
