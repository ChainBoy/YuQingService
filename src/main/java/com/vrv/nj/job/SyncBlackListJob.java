package com.vrv.nj.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vrv.nj.blacklist.IBlackListService;
import com.vrv.nj.blacklist.service.mongo.MonitorBlackListService;
import com.vrv.nj.company.service.IOrganizaitonMsgService;
import com.vrv.nj.domain.mongo.MonitorBlackList;
import com.vrv.nj.domain.mysql.BlackList;
import com.vrv.nj.domain.mysql.OrganizationMsg;
import com.vrv.nj.info.service.ISaveErrorLoggerService;

/**
 * 同步黑名单列表
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月24日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 同步黑名单列表
 */
public class SyncBlackListJob
{
    private static final Logger LOG = LoggerFactory.getLogger(SyncBlackListJob.class);
    
    @Autowired
    private MonitorBlackListService monitorBlackListService;
    
    @Autowired
    private IBlackListService blackListService;
    
    @Autowired
    private IOrganizaitonMsgService organizationMsgService;
    
    @Autowired
    private ISaveErrorLoggerService saveErrorLoggerService;
    
    public void execute()
    {
        LOG.info("###### sync black list job start ######");
        List<OrganizationMsg> orgs = this.organizationMsgService.findAccordOrgs();
        for (OrganizationMsg organizationMsg : orgs)
        {
            String organizationCode = organizationMsg.getOrganizationcode();
            List<MonitorBlackList> blackList = this.monitorBlackListService.findByOrganizationCode(organizationCode);
            BlackList bean = null;
            for (MonitorBlackList monitorBlackList : blackList)
            {
                String id = monitorBlackList.getId();
                bean = new BlackList();
                bean.setId(id);
                bean.setMainDomain(monitorBlackList.getMainDomain());
                bean.setOrganizationCode(monitorBlackList.getOrganizationCode());
                bean.setActive(monitorBlackList.getActive());
                bean.setAddTime(monitorBlackList.getAddTime());
                bean.setUpdateTime(monitorBlackList.getUpdateTime());
                BlackList enity = this.blackListService.findByPK(id);
                if(enity == null)
                {
                    try
                    {
                        this.blackListService.saveOne(bean);
                    }
                    catch (Exception e)
                    {
                        LOG.error("save black bean error",e);
                        this.saveErrorLoggerService.save("保存黑名单", e.getMessage());
                    }
                }
                else
                {
                    try
                    {
                        this.blackListService.updateOne(bean);
                    }
                    catch (Exception e)
                    {
                        LOG.error("update black bean error",e);
                        this.saveErrorLoggerService.save("更新黑名单", e.getMessage());
                    }
                }
                
            }
        }
        LOG.info("###### sync black list job end ######");
    }
}
