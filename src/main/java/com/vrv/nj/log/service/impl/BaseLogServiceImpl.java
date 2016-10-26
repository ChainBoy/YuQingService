package com.vrv.nj.log.service.impl;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.vrv.nj.common.Constants;
import com.vrv.nj.common.Right;
import com.vrv.nj.domain.mongo.BaseLog;
import com.vrv.nj.domain.mongo.BaseUser;
import com.vrv.nj.exception.YuQingException;
import com.vrv.nj.log.service.IBaseLogService;
import com.vrv.nj.util.IPUtil;

/**
 * @author 赵炎
 * @version [V1.00, 2016年8月26日]
 * @category 日志服务
 */
@Service("baseLogService")
public class BaseLogServiceImpl implements IBaseLogService
{
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public void save(HttpServletRequest request, String command, String remark)
        throws YuQingException
    {
        BaseUser baseUser = (BaseUser)request.getSession().getAttribute(Constants.SESSION_KEY);
        BaseLog baseLog = new BaseLog();
        baseLog.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        baseLog.setAccessIp(IPUtil.getIPByRequest(request));
        baseLog.setAccessIpArea(Constants.CHINA_TELECOM);
        baseLog.setCommand(command);
        baseLog.setCreateTime(new Date());
        baseLog.setOrganizationCode(baseUser.getOrganizationCode());
        baseLog.setUsername(baseUser.getUsername());
        baseLog.setUserRight(getUserRight(baseUser.getRoleId()));
        baseLog.setRemark(remark);
        try
        {
            this.mongoTemplate.save(baseLog);
        }
        catch (Exception e)
        {
            throw new YuQingException(e);
        }
    }
    
    /**
     * <p>
     * 根据角色id获取用户权限
     * </p>
     * 
     * @param roleId 角色id
     * @return <code>String</code>
     */
    private static String getUserRight(String roleId)
    {
        String right = null;
        if (Constants.SUPER_ADMIN.equals(roleId))
        {
            right = Right.SUPER_ADMIN;
        }
        if (Constants.ADMIN.equals(roleId))
        {
            right = Right.ADMIN;
        }
        if (Constants.USER.equals(roleId))
        {
            right = Right.USER;
        }
        
        return right;
    }
    
}
