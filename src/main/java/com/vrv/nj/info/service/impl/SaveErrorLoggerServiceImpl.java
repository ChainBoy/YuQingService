package com.vrv.nj.info.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.common.Constants;
import com.vrv.nj.domain.mysql.SystemErrorLog;
import com.vrv.nj.info.service.ISaveErrorLoggerService;
import com.vrv.nj.log.service.ISystemErrorLogService;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月14日]
 * @see [相关类/方法]
 * @since V1.00
 */
@Service("saveErrorLoggerService")
public class SaveErrorLoggerServiceImpl implements ISaveErrorLoggerService
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveErrorLoggerServiceImpl.class);
    
    @Autowired
    private ISystemErrorLogService systemErrorService;
    
    /**
     * 系统名
     */
    private static final String SYSTEM_NAME = Constants.SYSTEM;
    
    /**
     * 系统代码
     */
    private static final String SYSTEM_CODE = Constants.SYSTEM_CODE;
    
    /**
     * 保存错误日志
     * @param operator 操作
     * @param errorMsg 错误信息
     * @see [类、类#方法、类#成员]
     */
    @Override
    public void save(String operator, String errorMsg)
    {
        SystemErrorLog logger = new SystemErrorLog();
        logger.setLogId(generateLogId());
        logger.setSystemId(SYSTEM_CODE);
        logger.setSystemName(SYSTEM_NAME);
        logger.setOperator(operator);
        logger.setErrorMsg(errorMsg);
        try
        {
            this.systemErrorService.saveOne(logger);
        }
        catch (Exception e)
        {
            LOGGER.error("保存错误日志异常", e);
        }
    }
    
    /**
     * 生成系统日志id
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static String generateLogId()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
}
