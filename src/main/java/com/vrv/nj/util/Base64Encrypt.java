package com.vrv.nj.util;

import org.apache.geronimo.mail.util.Base64;

/**
 * 
 * @author 赵炎
 * @version [V1.00, 2016年9月2日]
 * @category base64加密/解密
 */
public class Base64Encrypt
{
    /**
     * 加密
     * 
     * @param source
     * @return <code>String</code>
     */
    public static String encode(String source)
    {
        return new String(Base64.encode(source.getBytes()));
    }
    
    /**
     * 解密
     * 
     * @param source
     * @return <code>String</code>
     */
    public static String decode(String source)
    {
        return new String(Base64.decode(source));
    }
}