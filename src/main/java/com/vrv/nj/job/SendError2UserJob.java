package com.vrv.nj.job;

import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vrv.nj.common.MailMessage;
import com.vrv.nj.common.ReturnMessage;
import com.vrv.nj.domain.mail.MailSenderInfo;
import com.vrv.nj.domain.mysql.SystemErrorLog;
import com.vrv.nj.log.service.ISystemErrorLogService;
import com.vrv.nj.mail.service.IMailMessageService;
import com.vrv.nj.util.DateUtil;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月14日]
 * @see [相关类/方法]
 * @since V1.00
 */
public class SendError2UserJob
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SendError2UserJob.class);
    
    @Autowired
    private ISystemErrorLogService systemErrorLogService;
    
    @Autowired
    private IMailMessageService mailMessageService;
    
    private static final int UNDO = 0;
    
    private static final int DONE = 1;
    
    public void execute()
        throws MessagingException
    {
        LOGGER.info("###### 定时任务定时发送邮件给开发者 START ######");
        List<SystemErrorLog> logs = this.systemErrorLogService.findByStatus(UNDO);
        if (logs != null && logs.size() > 0)
        {
            StringBuffer sb = new StringBuffer();
            sb.append(MailMessage.PREFIX_EMAIL);
            
            for (SystemErrorLog logger : logs)
            {
                sb.append("<tr>");
                sb.append("<td>").append(logger.getLogId()).append("</td>");
                sb.append("<td>").append(logger.getSystemName()).append("</td>");
                sb.append("<td>").append(logger.getOperator()).append("</td>");
                sb.append("<td>").append(DateUtil.date2String(logger.getCreateTime(), DateUtil.YYYYMMDDHHMMSS)).append("</td>");
                sb.append("<td>").append(logger.getErrorMsg()).append("</td>");
                sb.append("</tr>");
            }
            sb.append(MailMessage.SUFFIX_EMAIL);
            MailSenderInfo mailInfo = new MailSenderInfo();
            mailInfo.setToAddress(MailMessage.TO_EMAIL);
            mailInfo.setSubject(MailMessage.MAIL_SUBJECT);
            mailInfo.setContent(sb.toString());
            String returnMsg = this.mailMessageService.send(mailInfo);
            if (ReturnMessage.SEND_SUCCESS.equals(returnMsg))
            {
                for (SystemErrorLog logger : logs)
                {
                    logger.setStatus(DONE);
                    try
                    {
                        this.systemErrorLogService.updateOne(logger);
                    }
                    catch (Exception e)
                    {
                        LOGGER.error("update table t_system_error_log error", e);
                    }
                }
            }
            LOGGER.info(">>> 发送邮件：{}", returnMsg);
        }
        
        LOGGER.info("###### 定时任务定时发送邮件给开发者 END ######");
    }
    public static void main(String[] args) throws MessagingException
    {
        new SendError2UserJob().execute();
    }
}
