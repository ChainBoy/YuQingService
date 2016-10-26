package com.vrv.nj.domain.resp;

/**
 * 响应基类
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年8月23日]
 * @category 响应基类
 */
public class BaseResp
{
    /**
     * 返回码
     */
    private String returnCode;
    
    private boolean success;
    /**
     * 返回信息
     */
    private String message;
    
    /**
     * 请求时间
     */
    private long qtime;
    
    public String getReturnCode()
    {
        return returnCode;
    }

    public void setReturnCode(String returnCode)
    {
        this.returnCode = returnCode;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public long getQtime()
    {
        return qtime;
    }

    public void setQtime(long qtime)
    {
        this.qtime = qtime;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

}
