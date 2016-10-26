package com.vrv.nj.user.service.login.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.common.Constants;
import com.vrv.nj.common.Operator;
import com.vrv.nj.common.ReturnCode;
import com.vrv.nj.common.ReturnMessage;
import com.vrv.nj.domain.mongo.BaseUser;
import com.vrv.nj.domain.req.login.mobile.LoginMobileReq;
import com.vrv.nj.domain.req.login.web.LoginWebReq;
import com.vrv.nj.domain.resp.login.web.LoginWebResp;
import com.vrv.nj.exception.YuQingException;
import com.vrv.nj.log.service.IBaseLogService;
import com.vrv.nj.user.mongo.BaseUserService;
import com.vrv.nj.user.service.login.ILoginService;
import com.vrv.nj.util.DateUtil;
import com.vrv.nj.util.JsonUtil;
import com.vrv.nj.util.MD5Util;
import com.vrv.nj.util.ParamValidator;

/**
 * 登录接口
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月25日]
 * @category 登录接口实现类
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService
{
    /**
     * 系统日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
    
    @Autowired
    private IBaseLogService baseLogService;
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private BaseUserService baseUserService;
    
    @Override
    public String login(LoginMobileReq req)
    {
        LOGGER.info("###### moblie login into the system ######");
        
        return "login";
    }
    
    @Override
    public String login(LoginWebReq req)
    {
        LOGGER.info("###### web login into the system  ######");
        long reqTime = System.currentTimeMillis();
        LoginWebResp response = new LoginWebResp();
        if (!ParamValidator.validateParam(req))
        {
            response.setReturnCode(ReturnCode.FAILED_PARAM);
            response.setMessage(ReturnMessage.PARAM_INVALID);
            response.setSuccess(Boolean.FALSE);
        }
        else
        {
            String password = req.getPassword().trim();
            String encryptpwd = MD5Util.MD5(password);
            String username = req.getUsername().trim();
            List<BaseUser> baseUsers = this.baseUserService.findBaseUserByUsername(username);
            if (baseUsers.isEmpty())
            {
                response.setReturnCode(ReturnCode.FAILED);
                response.setMessage(ReturnMessage.USER_INEXISTENCE);
                response.setSuccess(Boolean.FALSE);
            }
            else
            {
                if (baseUsers.get(0).getPassword().equals(encryptpwd))
                {
                    response.setReturnCode(ReturnCode.SUCCESS);
                    response.setMessage(ReturnMessage.LOGIN_SUCCESS);
                    response.setSuccess(Boolean.TRUE);
                    this.request.getSession().setAttribute(Constants.SESSION_KEY, baseUsers.get(0));
                    try
                    {
                        this.baseLogService.save(request, Operator.LOGIN_WEB, ReturnMessage.LOGIN_SUCCESS);
                    }
                    catch (YuQingException e)
                    {
                        LOGGER.error("save logs failed", e);
                    }
                }
                else
                {
                    response.setReturnCode(ReturnCode.FAILED);
                    response.setSuccess(Boolean.FALSE);
                    response.setMessage(ReturnMessage.USERNAME_OR_PWD_ERROR);
                }
                
            }
            
        }
        response.setQtime(DateUtil.getDiffTime(reqTime));
        
        return JsonUtil.object2Str(response);
    }
    
}