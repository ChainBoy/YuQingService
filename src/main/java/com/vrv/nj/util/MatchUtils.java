package com.vrv.nj.util;

import org.apache.commons.lang.StringUtils;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月25日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 数据工具类
 */
public abstract class MatchUtils
{
    
    /**
     * BigDecimal regex.
     */
    public static final String BIG_DECIMAL_REGEX = "^(\\d+)||(\\d+\\.\\d+)$";
    
    /**
     * Positive Number regex.
     */
    public static final String POSITIVE_NUMBER_REGEX = "^\\d+$";
    
    /**
     * Email regex.
     */
    public static final String EMAIL_REGEX = ".+@.+\\.[a-z]+";
    
    private MatchUtils()
    {
    }
    
    /**
     * 判断字符串是否为数字
     * 
     * @param text
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean isBigDecimal(String text)
    {
        return StringUtils.isNotEmpty(text) && text.matches(BIG_DECIMAL_REGEX);
    }
    
    /**
     * 判断是否为合法的email
     * 
     * @param email
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmail(String email)
    {
        return StringUtils.isNotEmpty(email) && email.matches(EMAIL_REGEX);
    }
    
    /**
     * 是否为正数
     * 
     * @param numberText
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static boolean isPositiveNumber(String numberText)
    {
        return StringUtils.isNotEmpty(numberText) && numberText.matches(POSITIVE_NUMBER_REGEX);
    }
    
}