package com.vrv.nj.company.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vrv.nj.domain.req.company.DeleteReq;
import com.vrv.nj.domain.req.company.UpdateKeywordsReq;
import com.vrv.nj.domain.req.company.UpdateOrgMsgReq;
/**
 * 单位信息服务接口
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年9月30日]
 * @see  [相关类/方法]
 * @since V1.00
 * @category 单位信息服务接口
 */
@Path("/company")
public interface ICompanyService
{
    @POST
    @Path("/updatekeywords")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String updateKeyWordsTask(UpdateKeywordsReq req);
    
    
    @POST
    @Path("/loadAllData")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String loadAllData();
    
    @POST
    @Path("/updateOrgMsg")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String updateOrgMsg(UpdateOrgMsgReq req);
    
    @POST
    @Path("/delete")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String delete(DeleteReq req);
}
