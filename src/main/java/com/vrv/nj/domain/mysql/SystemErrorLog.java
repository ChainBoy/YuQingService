package com.vrv.nj.domain.mysql;

import java.io.Serializable;
import java.util.Date;

public class SystemErrorLog implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3473151299498684382L;
    
    private String logId;// 日志id
    
    private String systemId;// 系统id
    
    private String systemName;// 系统名称
    
    private Date createTime = new Date();// 创建时间
    
    private String operator;// 操作
    
    private String errorMsg;// 错误信息
    
    private int status;// 是否通知 0：未通知 1：已通知
    
    public String getLogId()
    {
        return logId;
    }
    
    public void setLogId(String logId)
    {
        this.logId = logId;
    }
    
    public String getSystemId()
    {
        return systemId;
    }
    
    public void setSystemId(String systemId)
    {
        this.systemId = systemId;
    }
    
    public String getSystemName()
    {
        return systemName;
    }
    
    public void setSystemName(String systemName)
    {
        this.systemName = systemName;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public String getErrorMsg()
    {
        return errorMsg;
    }
    
    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }
}
