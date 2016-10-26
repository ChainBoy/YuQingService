package com.vrv.nj.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vrv.nj.module.service.IMonitorModuleDataService;
import com.vrv.nj.util.DateUtil;

/**
 * 删除今天以外的数据
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月11日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 删除今天以外的数据
 */
public class DeleteBeforeTodayDataJob
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteBeforeTodayDataJob.class);
    
    @Autowired
    private IMonitorModuleDataService monitorModuleDataService;
    
    public void execute()
    {
        LOGGER.info("###### 定时任务删除今天之前的数据 START {} ######", DateUtil.getCurrentDateStr());
        long startLongDate = DateUtil.getBeginLongDate();
        try
        {
            this.monitorModuleDataService.deleteBeforeTodayData(startLongDate);
        }
        catch (Exception e)
        {
            LOGGER.error("delete data error ", e);
        }
        LOGGER.info("###### 定时任务删除今天之前的数据 END {} ######", DateUtil.getCurrentDateStr());
    }
}
