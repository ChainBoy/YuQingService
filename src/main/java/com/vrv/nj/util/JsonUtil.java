package com.vrv.nj.util;

import com.google.gson.Gson;

/**
 * json 工具类
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月23日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 工具类
 */
public class JsonUtil
{
    public JsonUtil()
    {
        super();
    }
    
    /**
     * <p>
     * 将对象转换成字符串
     * </p>
     * 
     * @param obj
     * @return <code>String</code>
     */
    public static String object2Str(Object obj)
    {
        Gson gson = new Gson();
        String str = gson.toJson(obj);
        return str;
    }
    
    /**
     * <p>
     * 将json字符串转换成响应对象
     * </p>
     * 
     * @param str
     * @param clazz
     * @return <code><T> T</code>
     */
    public static <T> T fromJson(String str, Class<T> clazz)
    {
        Gson gson = new Gson();
        return gson.fromJson(str, clazz);
    }
    
}
