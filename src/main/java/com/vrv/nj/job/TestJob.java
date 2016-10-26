
package com.vrv.nj.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vrv.nj.domain.mysql.SystemErrorLog;
import com.vrv.nj.log.service.ISystemErrorLogService;

public class TestJob
{
    @Autowired
    private ISystemErrorLogService systemErrorLogService;
    public void execute()
    {
        List<SystemErrorLog>  logs = this.systemErrorLogService.findByStatus(1);
        System.out.println(logs.size());
    }
}
