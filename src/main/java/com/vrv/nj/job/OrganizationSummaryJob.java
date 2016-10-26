package com.vrv.nj.job;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vrv.nj.common.ParamKey;
import com.vrv.nj.common.WebSiteType;
import com.vrv.nj.company.service.IOrganizaitonMsgService;
import com.vrv.nj.domain.mysql.OrganizationMsg;
import com.vrv.nj.domain.mysql.OrganizationSummary;
import com.vrv.nj.domain.mysql.WebSiteTypeCnt;
import com.vrv.nj.info.service.IDataBeanService;
import com.vrv.nj.info.service.IOrganizationSummaryService;
import com.vrv.nj.util.DateUtil;

/**
 * 单位汇总任务
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月9日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 单位汇总任务
 */
public class OrganizationSummaryJob
{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationSummary.class);
    
    @Autowired
    private IDataBeanService dataBeanService;
    
    @Autowired
    private IOrganizaitonMsgService organizationMsgService;
    
    @Autowired
    private IOrganizationSummaryService organizationSummaryService;
    
    public void execute()
        throws ParseException
    {
        Map<String, Object> reqMap = null;
        
        List<OrganizationMsg> orgs = this.organizationMsgService.findAccordOrgs();
        LOGGER.info("统计网站类型分类的单位有:{}个", orgs.size());
        for (OrganizationMsg organizationMsg : orgs)
        {
            String organizationCode = organizationMsg.getOrganizationcode();
            reqMap = new HashMap<String, Object>();
            // 当前日期
            Date currentDate = new Date();
            reqMap.put(ParamKey.ORGANIZATIONCODE, organizationMsg.getOrganizationcode());
            reqMap.put(ParamKey.STARTPOTIME, DateUtil.getBeginLongDate());
            reqMap.put(ParamKey.ENDPOTIME, DateUtil.getEndLongDate());
            List<WebSiteTypeCnt> dataList = this.dataBeanService.summaryByOrganization(reqMap);
            OrganizationSummary summary = this.organizationSummaryService.findByOrganizationCodeAndTime(organizationCode, DateUtil.format(currentDate));
            if (summary == null)
            {
                summary = new OrganizationSummary();
                summary.setOrganizationCode(organizationCode);
                summary.setRecord_time(DateUtil.format(currentDate));
                summary = dealWebSiteType(summary, dataList);
                try
                {
                    this.organizationSummaryService.insertSelective(summary);
                }
                catch (Exception e)
                {
                    LOGGER.error("保存数据异常", e);
                }
            }
            else
            {
                summary = dealWebSiteType(summary, dataList);
                this.organizationSummaryService.updateOrganizationSummary(summary);
            }
            
        }
        
    }
    
    /**
     * 根据网站类型处理结构信息
     * 
     * @param summary
     * @param dataList
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static OrganizationSummary dealWebSiteType(OrganizationSummary summary, List<WebSiteTypeCnt> dataList)
    {
        for (WebSiteTypeCnt webSiteTypeCnt : dataList)
        {
            long count = webSiteTypeCnt.getCnt();
            if (webSiteTypeCnt.getWebSiteType() == WebSiteType.ABROAD)
            {
                summary.setAbroad(count);
            }
            else if (webSiteTypeCnt.getWebSiteType() == WebSiteType.BOKE)
            {
                summary.setBoke(count);
            }
            else if (webSiteTypeCnt.getWebSiteType() == WebSiteType.FORUM)
            {
                summary.setForum(count);
            }
            else if (webSiteTypeCnt.getWebSiteType() == WebSiteType.MEDIA)
            {
                summary.setMedia(count);
            }
            else if (webSiteTypeCnt.getWebSiteType() == WebSiteType.NEWS)
            {
                summary.setNews(count);
            }
            else if (webSiteTypeCnt.getWebSiteType() == WebSiteType.TIEBA)
            {
                summary.setTieba(count);
            }
            else if (webSiteTypeCnt.getWebSiteType() == WebSiteType.TWITTER)
            {
                summary.setTwitter(count);
            }
            else if (webSiteTypeCnt.getWebSiteType() == WebSiteType.WEIBO)
            {
                summary.setWeibo(count);
            }
            else
            {
                summary.setWeixin(count);
            }
        }
        return summary;
    }
}
