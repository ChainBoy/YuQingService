package com.vrv.nj.log.service;

import javax.servlet.http.HttpServletRequest;

import com.vrv.nj.exception.YuQingException;

/**
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月26日]
 * @category 日志服务接口
 */
public interface IBaseLogService
{
    /**
     * <p>
     * 保存日志
     * </p>
     * 
     * @param request
     * @param command 操作
     * @param remark 修改内容
     * @throws YuQingException 
     */
    public void save(HttpServletRequest request, String command, String remark) throws YuQingException;
}
