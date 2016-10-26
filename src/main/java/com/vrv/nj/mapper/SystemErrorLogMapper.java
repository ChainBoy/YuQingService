package com.vrv.nj.mapper;

import java.util.Date;
import java.util.List;

import com.vrv.nj.domain.mysql.SystemErrorLog;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月14日]
 * @see [相关类/方法]
 * @since V1.00
 */
public interface SystemErrorLogMapper
{
    /**
     * 根据状态查询日志
     * 
     * @param status
     * @return
     */
    public List<SystemErrorLog> selectByStatus(int status);
    
    /**
     * 单条数据入库
     * 
     * @param log
     */
    public void insertOne(SystemErrorLog log);
    
    /**
     * 更新单条数据
     * 
     * @param log
     */
    public void updateOne(SystemErrorLog log);
    
    /**
     * 删除七天前数据
     * 
     * @param date
     */
    public void deleteBefore7DaysLog(Date date);
}
