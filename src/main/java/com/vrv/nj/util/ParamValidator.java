package com.vrv.nj.util;

import java.lang.reflect.Field;

/**
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年8月28日]
 * @category 参数校验
 */
public class ParamValidator
{
    /**
     * <p>
     * 校验接口参数是否合法
     * </p>
     * 
     * @param obj 检验参数
     * @return <code>true</code> 参数合法
     */
    public static boolean validateParam(Object obj)
    {
        // 初始化
        boolean flag = false;
        // 获取对象定义的字段
        Field[] fields = obj.getClass().getDeclaredFields();
        
        for (Field field : fields)
        {
            // 私有必须使用这个字段设置
            field.setAccessible(true);
            
            try
            {
                // 获取当前字段的value值
                Object object = field.get(obj);
    
                if (object == null)
                {
                    break;
                }
                else
                {
                    // 如果是String类型的参数，则进行非空的校验
                    if (StringUtil.isNotBlank(object.toString()))
                    {
                        flag = true;
                        continue;
                    }
          
                }
            }
            catch (IllegalArgumentException e)
            {
                flag = false;
            }
            catch (IllegalAccessException e)
            {
                flag = false;
            }
        }
        return flag;
    }
}