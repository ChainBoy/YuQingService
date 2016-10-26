package com.vrv.nj.common;

import java.util.Properties;

import com.vrv.nj.util.PropertiesUtil;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月26日]
 * @category 响应信息
 */
public class ReturnMessage
{
    static Properties properties = null;
    static
    {
        properties = PropertiesUtil.getProperties("returnMessage");
    }
    
    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = properties.getProperty("YQ0000").trim();
    
    /**
     * 登录失败
     */
    public static final String LOGIN_ERROR = properties.getProperty("YQ0001").trim();
    
    /**
     * 参数不合法
     */
    public static final String PARAM_INVALID = properties.getProperty("YQ0002").trim();
    
    /**
     * 用户不存在
     */
    public static final String USER_INEXISTENCE = properties.getProperty("YQ0003").trim();
    
    /**
     * 用户名或密码不正确
     */
    public static final String USERNAME_OR_PWD_ERROR = properties.getProperty("YQ0004").trim();
    
    /**
     * 注册成功
     */
    public static final String REGISTER_SUCCESS = properties.getProperty("YQ0005").trim();
    
    /**
     * 注册失败
     */
    public static final String REGISTER_FAIL = properties.getProperty("YQ0006").trim();
    
    /**
     * 邮箱非法
     */
    public static final String EMAIL_INVALID = properties.getProperty("YQ0007").trim();
    
    /**
     * 身份证非法
     */
    public static final String IDNO_INVALID = properties.getProperty("YQ0008").trim();
    
    /**
     * 发送成功
     */
    public static final String SEND_SUCCESS = properties.getProperty("YQ0009").trim();
    
    /**
     * 发送失败
     */
    public static final String SEND_FAIL = properties.getProperty("YQ0010").trim();
    
    /**
     * 帖子不存在
     */
    public static final String NO_EXIST = properties.getProperty("YQ0011").trim();
    
    /**
     * 帖子已阅
     */
    public static final String ALREADY_READ = properties.getProperty("YQ0012").trim();
    
    /**
     * 标记失败
     */
    public static final String TIPREAD_ERROR = properties.getProperty("YQ0013").trim();
    
    /**
     * 标记已阅成功
     */
    public static final String TIPREAD_SUCCESS = properties.getProperty("YQ0014").trim();
    
    /**
     * 删除帖子异常
     */
    public static final String DELET_TIP_ERROR = properties.getProperty("YQ0015").trim();
    
    /**
     * 删除的帖子不存在
     */
    public static final String DELET_TIP_NO_EXIST = properties.getProperty("YQ0016").trim();
    
    /**
     * 删除帖子成功
     */
    public static final String DELET_TIP_SUCCESS = properties.getProperty("YQ0017").trim();
    
    /**
     * 查询成功
     */
    public static final String QUERY_SUCCESS = properties.getProperty("YQ0018").trim();
    
    /**
     * 关键词无变化
     */
    public static final String NO_KEY_CHANGE = properties.getProperty("YQ0019").trim();
    
    /**
     * 更新成功
     */
    public static final String UPDATE_SUCCESS = properties.getProperty("YQ0020").trim();
    
    /**
     * 更新失败
     */
    public static final String UPDATE_FAILED = properties.getProperty("YQ0021").trim();
    
    /**
     * 系统内部错误
     */
    public static final String INNER_ERROR = properties.getProperty("YQ0022").trim();
    
    /**
     * 删除单位信息失败
     */
    public static final String DELET_ORG_ERROR = properties.getProperty("YQ0023").trim();
    
    public static final String DELET_ORG_SUCCESS = properties.getProperty("YQ0024").trim();
    
    public static final String NO_EXIST_ORG = properties.getProperty("YQ0025").trim();
    
    public static final String UPDATE_ORG_SUCCESS = properties.getProperty("YQ0026").trim();
}
