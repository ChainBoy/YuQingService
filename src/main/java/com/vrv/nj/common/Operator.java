package com.vrv.nj.common;

import java.util.Properties;

import com.vrv.nj.util.PropertiesUtil;

/**
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月26日]
 * @category 用户操作
 */
public class Operator
{
    private static Properties properties = null;
    
    static
    {
        properties = PropertiesUtil.getProperties("operator");
    }
    
    // ==============================登录===============================
    /**
     * web登录
     */
    public static final String LOGIN_WEB = properties.getProperty("login_web").trim();
    
    /**
     * 手机登录
     */
    public static final String LOGIN_MOBILE = properties.getProperty("login_mobile").trim();
    
    /**
     * 退出
     */
    public static final String LOGINOUT = properties.getProperty("loginout").trim();
    
    // ==============================注册===============================
    /**
     * 注册
     */
    /**
     * web端注册
     */
    public static final String WEB_REGISTER = properties.getProperty("register_web").trim();
    
    /**
     * 手机端注册
     */
    public static final String MOBILE_REGISTER = properties.getProperty("login_mobile").trim();
    
    // ==============================密码===============================
    /**
     * 修改密码
     */
    public static final String UPDATE_PWD = properties.getProperty("updatepwd").trim();
    
    // ==============================关键词===============================
    /**
     * 修改关键词
     */
    public static final String UPDATE_KEYWORDS = properties.getProperty("updateKeywords").trim();
    
    /**
     * 删除关键词
     */
    public static final String DEL_KEYWORDS = properties.getProperty("delKeywords").trim();
    
    // ==============================分类===============================
    /**
     * 添加分类
     */
    public static final String ADD_CATEGORY = properties.getProperty("addCategory").trim();
    
    /**
     * 删除分类
     */
    public static final String DEL_CATEGORY = properties.getProperty("delCategory").trim();
    
    /**
     * 修改分类
     */
    public static final String UPDATE_CATEGORY = properties.getProperty("updateCategory").trim();
    
    // ==============================模块===============================
    /**
     * 添加模块
     */
    public static final String ADD_MODULE = properties.getProperty("addModule").trim();
    
    /**
     * 删除模块
     */
    public static final String DEL_MODULE = properties.getProperty("delModule").trim();
    
    /**
     * 修改模块
     */
    public static final String UPDATE_MODULE = properties.getProperty("updateModule").trim();
    
    // ==============================黑名单===============================
    /**
     * 删除黑名单
     */
    public static final String DEL_BLACKLIST = properties.getProperty("delBlacklist").trim();
    
    /**
     * 添加黑名单
     */
    public static final String ADD_BLACKLIST = properties.getProperty("addBlacklist").trim();
    
    /**
     * 修改黑名单
     */
    public static final String UPDATE_BLACKLIST = properties.getProperty("updateBlacklist").trim();
    
    // ==============================报警===============================
    /**
     * 添加报警
     */
    public static final String ADD_ALERT = properties.getProperty("addAlert").trim();
    
    /**
     * 删除报警
     */
    public static final String DEL_ALERT = properties.getProperty("delAlert").trim();
    
    // ==============================报告===============================
    /**
     * 导出日报
     */
    public static final String EXPORT_REPORT = properties.getProperty("exportReport").trim();
    
    /**
     * 批量已阅
     */
    public static final String BATCH_READ = properties.getProperty("batchRead").trim();
    
    /**
     * 查询
     */
    public static final String QUERY = properties.getProperty("query").trim();
    
    /**
     * 批量删除
     */
    public static final String BATCH_DELETE = properties.getProperty("batchDelete").trim();
    
    /**
     * 统计
     */
    public static final String SUMMAY = properties.getProperty("summary").trim();
    
    /**
     * 首页模块数据加载
     */
    public static final String LOAD_DATA = properties.getProperty("loadData").trim();
}
