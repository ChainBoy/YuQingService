package com.vrv.nj.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取配置文件工具类
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月23日]
 * @category 读取配置文件工具类
 */
public class PropertiesUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtil.class);
    
    /**
     * <p>
     * constructor
     * </p>
     */
    public PropertiesUtil()
    {
        super();
    }
    
    /**
     * <p>
     * 获取键映射的value
     * </p>
     * 
     * @param key 键
     * @param filename 文件名
     * @return <code>String</code>
     */
    private static String getValue(String key, String filename)
    {
        Properties properties = PropertiesUtil.getProperties(filename);
        return properties.getProperty(key).trim();
    }
    
    /**
     * <p>
     * 读取int类型数据
     * </p>
     * 
     * @param key 键
     * @param filename 文件名
     * @return <code>int</code>
     */
    private static int getInt(String key, String filename)
    {
        String str = PropertiesUtil.getValue(key, filename);
        int initValue = 0;
        try
        {
            initValue = Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            LOGGER.error("读取{}文件中int类型键{}异常", filename, key);
        }
        return initValue;
    }
    
    /**
     * <p>
     * 读取long类型数据
     * </p>
     * 
     * @param key 键
     * @return <code>long</code>
     */
    private static long getLong(String key, String filename)
    {
        String str = PropertiesUtil.getValue(key, filename);
        long initValue = 0;
        try
        {
            initValue = Long.parseLong(str);
        }
        catch (NumberFormatException e)
        {
            LOGGER.error("读取{}文件中long类型键{}异常", filename, key);
        }
        return initValue;
    }
    
    /**
     * <p>
     * 读取double类型数据
     * </p>
     * 
     * @param key 键
     * @return <code>double</code>
     */
    private static double getDouble(String key, String filename)
    {
        String str = PropertiesUtil.getValue(key, filename);
        double initValue = 0;
        try
        {
            initValue = Double.parseDouble(str);
        }
        catch (NumberFormatException e)
        {
            LOGGER.error("读取{}文件中double类型键{}异常", filename, key);
        }
        return initValue;
    }
    
    /**
     * <p>
     * 读取double类型数据
     * </p>
     * 
     * @param key
     * @param filename 文件名
     * @return <code>String</code>
     */
    public static String getString(String key, String filename)
    {
        return PropertiesUtil.getValue(key, filename);
    }
    
    /**
     * <p>
     * 读取响应文件中double类型数据
     * </p>
     * 
     * @param key 键
     * @param filename 文件名
     * @return <code>double</code>
     */
    public static double getDoubleValue(String key, String filename)
    {
        return PropertiesUtil.getDouble(key, filename);
    }
    
    /**
     * <p>
     * 读取响应文件中int类型数据
     * </p>
     * 
     * @param key 键
     * @param filename 文件名
     * @return <code>int</code>
     */
    public static int getIntValue(String key, String filename)
    {
        return PropertiesUtil.getInt(key, filename);
    }
    
    /**
     * <p>
     * 读取响应文件中long类型数据
     * </p>
     * 
     * @param key 键
     * @param filename 文件名
     * @return <code>long</code>
     */
    public static long getLongValue(String key, String filename)
    {
        return PropertiesUtil.getLong(key, filename);
    }
    
    public static Properties getProperties(String filename)
    {
        Properties properties = new Properties();
        filename = filename + ".properties";
        try
        {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(filename));
        }
        catch (IOException e)
        {
            LOGGER.error("加载配置文件{}异常", filename);
        }
        return properties;
    }
    
}
