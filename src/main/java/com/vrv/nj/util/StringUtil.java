package com.vrv.nj.util;

/**
 * 字符串工具类
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月23日]
 * @category 字符串工具类
 */
public class StringUtil
{
    /**
     * <p>
     * <code>StringUtil</code>
     * </p>
     * <p>
     * 构造函数：工具类实例化JavaBean
     * </p>
     */
    public StringUtil()
    {
        super();
    }
    
    /**
     * <p>
     * Checks if a String is empty ("") or null.
     * </p>
     * 
     * @param str 需要检查的字符串，可能为null
     * @return <code>true</code> 字符串为空或者null
     */
    public static boolean isEmpty(String str)
    {
        return str == null || str.length() == 0;
    }
    
    /**
     * <p>
     * Checks if a String is not empty ("") and not null.
     * </p>
     * 
     * <pre>
     * StringUtil.isNotEmpty(null)      = false
     * StringUtil.isNotEmpty("")        = false
     * StringUtil.isNotEmpty(" ")       = true
     * StringUtil.isNotEmpty("bob")     = true
     * StringUtil.isNotEmpty("  bob  ") = true
     * </pre>
     * 
     * @param str 检查字符串
     * @return <code>true</code> 字符串不为空或者null
     */
    public static boolean isNotEmpty(String str)
    {
        return !StringUtil.isEmpty(str);
    }
    
    /**
     * <p>
     * Checks if a String is whitespace, empty ("") or null.
     * </p>
     * 
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     * 
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     */
    public static boolean isBlank(String str)
    {
        int strLen;
        if (null == str || (strLen = str.length()) == 0)
        {
            return true;
        }
        for (int i = 0; i < strLen; i++)
        {
            if ((Character.isWhitespace(str.charAt(i)) == false))
            {
                return false;
            }
            
        }
        return true;
    }
    
    /**
     * <p>
     * Checks if a String is not whitespace
     * </p>
     * 
     * @param str the String to check,may be null
     * @return <code>true</code> if the String is not null ,not empty or no whitespace
     */
    public static boolean isNotBlank(String str)
    {
        return !StringUtil.isBlank(str);
    }
}
