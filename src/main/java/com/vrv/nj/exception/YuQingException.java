package com.vrv.nj.exception;

/**
 * 自定义异常类
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月11日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 自定义异常
 */
public class YuQingException extends Exception
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    public YuQingException()
    {
        super();
    }
    
    public YuQingException(String message)
    {
        super(message);
    }
    
    public YuQingException(Throwable cause)
    {
        super(cause);
    }
    
    public YuQingException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
