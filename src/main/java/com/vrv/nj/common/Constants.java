package com.vrv.nj.common;

import java.util.Properties;

import com.vrv.nj.util.PropertiesUtil;

/**
 * 常量
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月25日]
 * @category 常量
 */
public class Constants
{
    static Properties properties = null;
    static
    {
        properties = PropertiesUtil.getProperties("constants");
    }
    
    /**
     * session
     */
    public static final String SESSION_KEY = "session_baseuser";
    
    /**
     * 超级管理员
     */
    public static final String SUPER_ADMIN = "0";
    
    /**
     * 管理员
     */
    public static final String ADMIN = "1";
    
    /**
     * 普通用户
     */
    public static final String USER = "2";
    
    /**
     * 中国电信
     */
    public static final String CHINA_TELECOM = properties.getProperty("CHINATELECOM").trim();
    
    public static final String UNKOWN = properties.getProperty("UNKOWN").trim();
    
    public static final String LOCAL_LOGIN = properties.getProperty("LOCAL_LOGIN").trim();
    
    public static final String EMAIL_PATTERN = properties.getProperty("EMAIL_PATTERN").trim();
    
    public static final String IDNO_PATTERN = properties.getProperty("IDNO_PATTERN").trim();
    
    // ************************
    /**
     * read : 1已阅
     */
    public static final String READ = "1";
    
    /**
     * 未读
     */
    public static final String NOREAD = "0";
    
    /**
     * 默认值
     */
    public static final String DEFAULT = "-1";
    
    /**
     * 系统名
     */
    public static final String SYSTEM = properties.getProperty("SYSTEM_NAME").trim();
    
    /**
     * 系统码
     */
    public static final String SYSTEM_CODE = properties.getProperty("SYSTEM_NAME").trim();
    
    /**
     * 监听端口
     */
    public static final int LISTEN_PORT = Integer.parseInt(properties.getProperty("LISTEN_PORT"));
    
    /**
     * 监听ip
     */
    public static final String LISTEN_IP = properties.getProperty("LISTEN_IP").trim();
    
    public static final String HEART_BEAT_CN = properties.getProperty("HEART_BEAT_CN").trim();
}
