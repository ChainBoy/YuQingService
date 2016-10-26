package com.vrv.nj.log.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vrv.nj.domain.mysql.SystemErrorLog;
import com.vrv.nj.log.service.ISystemErrorLogService;
import com.vrv.nj.mapper.SystemErrorLogMapper;

/**
 * 系统错误日志服务
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月14日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 系统错误日志服务
 */
@Service("systemErrorLogService")
public class SystemErrorLogServiceImpl implements ISystemErrorLogService
{
    
    @Autowired
    private SystemErrorLogMapper systemErrorLogMapper;
    
    @Transactional
    @Override
    public void saveOne(SystemErrorLog log)
    {
        this.systemErrorLogMapper.insertOne(log);
        
    }
    
    @Transactional
    @Override
    public void updateOne(SystemErrorLog log)
    {
        this.systemErrorLogMapper.updateOne(log);
    }
    
    @Override
    public List<SystemErrorLog> findByStatus(int status)
    {
        return this.systemErrorLogMapper.selectByStatus(status);
    }
    
    @Transactional
    @Override
    public void deleteBefore7DaysLog(Date date)
    {
        this.systemErrorLogMapper.deleteBefore7DaysLog(date);
    }
    
}
