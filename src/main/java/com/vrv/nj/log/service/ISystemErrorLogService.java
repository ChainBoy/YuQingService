package com.vrv.nj.log.service;

import java.util.Date;
import java.util.List;

import com.vrv.nj.domain.mysql.SystemErrorLog;

public interface ISystemErrorLogService
{
    public void saveOne(SystemErrorLog log);
    
    public void updateOne(SystemErrorLog log);
    
    public List<SystemErrorLog> findByStatus(int status);
    
    public void deleteBefore7DaysLog(Date date);
}
