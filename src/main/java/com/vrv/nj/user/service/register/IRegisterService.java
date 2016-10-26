package com.vrv.nj.user.service.register;

import javax.mail.MessagingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vrv.nj.domain.req.register.RegisterReq;

/**
 * @author 赵炎
 * @version [V1.00, 2016年9月1日]
 * @category 注册接口
 */
@Path("/register")
public interface IRegisterService
{
    /**
     * 手机端登陆
     * */
    @POST
    @Path("/mobile")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String register();
    
    @POST
    @Path("/web")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String register(RegisterReq req) throws MessagingException;
}
