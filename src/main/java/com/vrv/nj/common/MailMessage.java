package com.vrv.nj.common;

import java.util.Properties;

import com.vrv.nj.util.PropertiesUtil;

public class MailMessage
{
    static Properties properties = null;
    static
    {
        properties = PropertiesUtil.getProperties("mail");
    }
    
    /**
     * 接受者邮箱
     */
    public static final String TO_EMAIL = properties.getProperty("to_email").trim();
    
    /**
     * 邮件协议
     */
    public static final String MAIL_PROTOCOL = properties.getProperty("mail.transport.protocol").trim();
    
    /**
     * 端口
     */
    public static final String MAIL_PORT = properties.getProperty("mail.smtp.port").trim();
    
    /**
     * 邮件发送主机
     */
    public static final String MAIL_HOST = properties.getProperty("mail.smtp.host").trim();
    
    public static final boolean MAIL_AUTH = Boolean.parseBoolean(properties.getProperty("mail.smtp.auth").trim());
    
    public static final String MAIL_SUBJECT = properties.getProperty("subject").trim();
    
    public static final String FROM_USEREAMIL = properties.getProperty("from_username").trim();
    
    public static final String FROM_USERPWD = properties.getProperty("from_password").trim();
    
    public static final String PREFIX_EMAIL = properties.getProperty("prefix_email").trim();

    public static final String SUFFIX_EMAIL = properties.getProperty("suffix_email").trim();
}
