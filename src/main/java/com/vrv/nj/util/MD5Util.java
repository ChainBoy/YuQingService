package com.vrv.nj.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月23日]
 * @see [相关类/方法]
 * @since V1.00
 * @category MD5工具类
 */
public class MD5Util
{
    private static final String MD5 = "MD5";
    
    public MD5Util()
    {
        super();
    }
    
    /**
     * <p>
     * 加密字符串
     * </p>
     * 
     * @param source
     * @return <code>String</code> 加密后的字符串
     */
    public static String MD5(String source)
    {
        MessageDigest md = null;
        try
        {
            // 生成MessageDigest对象
            md = MessageDigest.getInstance(MD5);
            
            byte[] byteArray = MD5Util.getBytes(source);
            
            // 将指定的字节更新到摘要中
            md.update(byteArray);
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return null;
        }
        // 加密后的密文
        byte[] encryptBytes = md.digest();
        // 把密文转成16进制
        return MD5Util.bytes2Hex(encryptBytes);
    }
    
    /**
     * <p>
     * 获取字节数组
     * </p>
     * 
     * @param source
     * @return <code>byte[]</code>
     */
    public static byte[] getBytes(String source)
    {
        return source.getBytes();
    }
    
    /**
     * <p>
     * 字节数组转换成16进制
     * </p>
     * 
     * @param bytes
     * @return <code>String</code>
     */
    public static String bytes2Hex(byte[] bytes)
    {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] chars = new char[bytes.length * 2];
        int k = 0;
        for (int i = 0; i < bytes.length; i++)
        {
            byte b = bytes[i];
            chars[k++] = hexDigits[b >>> 4 & 0xf];
            chars[k++] = hexDigits[b & 0xf];
        }
        // 将字节数组组合成字符串返回
        return new String(chars);
    }
    
}
