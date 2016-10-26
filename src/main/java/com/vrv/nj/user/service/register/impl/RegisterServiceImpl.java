package com.vrv.nj.user.service.register.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.common.Constants;
import com.vrv.nj.common.ReturnCode;
import com.vrv.nj.common.ReturnMessage;
import com.vrv.nj.domain.mail.MailSenderInfo;
import com.vrv.nj.domain.req.register.RegisterReq;
import com.vrv.nj.domain.resp.register.RegisterResp;
import com.vrv.nj.mail.service.IMailMessageService;
import com.vrv.nj.user.service.register.IRegisterService;
import com.vrv.nj.util.DateUtil;
import com.vrv.nj.util.JsonUtil;
import com.vrv.nj.util.ParamValidator;

/**
 * @author 赵炎
 * @version [V1.00, 2016年9月1日]
 * @category 用户注册服务
 */
@Service("registerService")
public class RegisterServiceImpl implements IRegisterService
{
    /**
     * LOGGER 运行日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);
    
    
    @Autowired
    private IMailMessageService mailMessageService;
    
    @Override
    public String register()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String register(RegisterReq req)
        throws MessagingException
    {
        LOGGER.info("###### web register user ######");
        long reqTime = System.currentTimeMillis();
        RegisterResp resp = new RegisterResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            return JsonUtil.object2Str(resp);
        }
        else
        {
            // TODO 身份证号码校验 邮箱校验
            String email = req.getEmail().trim();
            Pattern p = Pattern.compile(Constants.EMAIL_PATTERN);
            Matcher m = p.matcher(email);
            if (!m.find())
            {
                resp.setReturnCode(ReturnCode.FAILED);
                resp.setMessage(ReturnMessage.EMAIL_INVALID);
                resp.setSuccess(Boolean.FALSE);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                return JsonUtil.object2Str(resp);
            }
            else
            {
                String idNo = req.getIdNo().trim();
                p = Pattern.compile(Constants.IDNO_PATTERN);
                m = p.matcher(idNo);
                if (!m.find())
                {
                    resp.setReturnCode(ReturnCode.FAILED);
                    resp.setMessage(ReturnMessage.IDNO_INVALID);
                    resp.setSuccess(Boolean.FALSE);
                    resp.setQtime(DateUtil.getDiffTime(reqTime));
                    return JsonUtil.object2Str(resp);
                }
                
                MailSenderInfo mailInfo = new MailSenderInfo();
                mailInfo.setToAddress(email);
                mailInfo.setSubject("注册成功");
                StringBuffer sb = new StringBuffer();
                sb.append("欢迎您注册北信源网情监测系统，链接地址： ");
                sb.append("<a href=\'http://61.147.124.113:8899/webmonitor-web'>");
                sb.append("http://61.147.124.113:8899/webmonitor-web");
                sb.append("</a>");
                sb.append("谢谢您的使用。");
                mailInfo.setContent(sb.toString());
                String returnMsg = this.mailMessageService.send(mailInfo);
                resp.setReturnCode(ReturnCode.SUCCESS);
                resp.setSuccess(Boolean.TRUE);
                resp.setMessage(ReturnMessage.REGISTER_SUCCESS + "," + email + returnMsg);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                return JsonUtil.object2Str(resp);
            }
            
        }
        
    }
    
}
