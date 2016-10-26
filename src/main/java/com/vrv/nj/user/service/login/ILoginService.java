package com.vrv.nj.user.service.login;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vrv.nj.domain.req.login.mobile.LoginMobileReq;
import com.vrv.nj.domain.req.login.web.LoginWebReq;

/**
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月25日]
 * @category 登录接口
 */
@Path("/login")
public interface ILoginService
{
    /**
     * 手机端登陆
     * */
    @POST
    @Path("/mobile")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String login(LoginMobileReq req);
    
    /**
     * web端登陆
     * */
    @POST
    @Path("/web")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String login(LoginWebReq req);
}
