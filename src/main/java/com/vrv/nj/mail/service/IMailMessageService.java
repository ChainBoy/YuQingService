package com.vrv.nj.mail.service;

import javax.mail.MessagingException;

import com.vrv.nj.domain.mail.MailSenderInfo;


/**
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年8月31日]
 * @category 邮件接口
 */
public interface IMailMessageService
{
    public String send(MailSenderInfo mailSenderInfo) throws MessagingException;
}
