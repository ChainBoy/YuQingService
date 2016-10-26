package com.vrv.nj.common;

import java.util.Properties;

import com.vrv.nj.util.PropertiesUtil;

/**
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年8月29日]
 * @category 权限
 */
public class Right
{
    static Properties properties = null;
    static
    {
        properties = PropertiesUtil.getProperties("right");
    }
    /**
     * 超级管理员
     */
    public static final String SUPER_ADMIN = properties.getProperty("superadmin").trim();
    /**
     * 管理员
     */
    public static final String ADMIN = properties.getProperty("admin").trim();
    /**
     * 普通用户
     */
    public static final String USER = properties.getProperty("user").trim();
}
