package com.vrv.nj.info.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.common.Constants;
import com.vrv.nj.common.Operator;
import com.vrv.nj.common.ParamKey;
import com.vrv.nj.common.ReturnCode;
import com.vrv.nj.common.ReturnMessage;
import com.vrv.nj.common.WebSiteType;
import com.vrv.nj.domain.mysql.DataBean;
import com.vrv.nj.domain.mysql.OrganizationSummary;
import com.vrv.nj.domain.mysql.WebSiteTypeCnt;
import com.vrv.nj.domain.req.info.DeleteReq;
import com.vrv.nj.domain.req.info.QueryReq;
import com.vrv.nj.domain.req.info.SummaryReq;
import com.vrv.nj.domain.req.info.TipReadReq;
import com.vrv.nj.domain.resp.info.DeleteResp;
import com.vrv.nj.domain.resp.info.QueryResp;
import com.vrv.nj.domain.resp.info.SummaryResp;
import com.vrv.nj.domain.resp.info.TipReadResp;
import com.vrv.nj.info.service.IDataBeanService;
import com.vrv.nj.info.service.IOrganizationSummaryService;
import com.vrv.nj.info.service.ISaveErrorLoggerService;
import com.vrv.nj.info.service.IShowInfoService;
import com.vrv.nj.util.DateUtil;
import com.vrv.nj.util.JsonUtil;
import com.vrv.nj.util.ParamValidator;
import com.vrv.nj.util.StringUtil;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年9月30日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 信息展示接口
 */
@Service("showInfoService")
public class ShowInfoServiceImpl implements IShowInfoService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowInfoServiceImpl.class);
    
    @Autowired
    private IDataBeanService dataBeanService;
    
    @Autowired
    private IOrganizationSummaryService organizationSummaryService;
    
    private static final String SPLIT = ",";
    
    @Autowired
    private ISaveErrorLoggerService saveErrorLoggerService;
    
    @Override
    public String tipRead(TipReadReq req)
    {
        LOGGER.info("###### batch tip read  records ######");
        long reqTime = System.currentTimeMillis();
        TipReadResp resp = new TipReadResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            this.saveErrorLoggerService.save(Operator.BATCH_READ,ReturnMessage.PARAM_INVALID);
            return JsonUtil.object2Str(resp);
        }
        else
        {
            Map<String, Object> reqMap = new HashMap<String, Object>();
            String organizationCode = req.getOrganizationCode().trim();
            reqMap.put(ParamKey.ORGANIZATIONCODE, organizationCode);
            String ids = req.getIds();
            String[] idsStr = ids.split(SPLIT);
            List<String> idList = Arrays.asList(idsStr);
            reqMap.put(ParamKey.IDS, idList);
            try
            {
                this.dataBeanService.batchUpdateInfo(reqMap);
            }
            catch (Exception e)
            {
                LOGGER.error("batch tip read records failed", e);
                resp.setReturnCode(ReturnCode.FAILED);
                resp.setMessage(ReturnMessage.TIPREAD_ERROR);
                resp.setSuccess(Boolean.FALSE);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                this.saveErrorLoggerService.save(Operator.BATCH_READ, e.getMessage());
                return JsonUtil.object2Str(resp);
            }
            
            resp.setReturnCode(ReturnCode.SUCCESS);
            resp.setMessage(ReturnMessage.TIPREAD_SUCCESS);
            resp.setSuccess(Boolean.TRUE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            return JsonUtil.object2Str(resp);
        }
    }
    
    @Override
    public String query(QueryReq req)
    {
        long reqTime = System.currentTimeMillis();
        QueryResp resp = new QueryResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setData(null);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            this.saveErrorLoggerService.save(Operator.QUERY, ReturnMessage.PARAM_INVALID);
            return JsonUtil.object2Str(resp);
        }
        else
        {
            // 当前页
            int currentPage = req.getCurrentPage();
            // 开始发布时间
            long startPoTime = req.getStartPoTime();
            // 结束发布时间
            long endPoTime = req.getEndPoTime();
            // 单位编码
            String organizationCode = req.getOrganizationCode().trim();
            // 是否已读
            String read = req.getRead().trim();
            // 正负面
            int positiveOrNegative = req.getPositiveOrNegative();
            // 排序方式
            String sort = req.getSort().trim();
            String webSiteType = req.getWebSiteType().trim();
            String blackList = req.getBlackList();
            
            // 每页显示条数
            int limit = req.getLimit();
            Map<String, Object> reqMap = new HashMap<String, Object>();
            // 网站类型
            if (!Constants.DEFAULT.equals(webSiteType))
            {
                reqMap.put(ParamKey.WEBSITETYPE, webSiteType);
            }
            reqMap.put(ParamKey.STARTPOTIME, startPoTime);
            reqMap.put(ParamKey.ENDPOTIME, endPoTime);
            
            // 正负面
            if (positiveOrNegative != -1)
            {
                reqMap.put(ParamKey.POSITIVEORNEGATIVE, positiveOrNegative);
            }
            // 已阅未阅
            if (!Constants.DEFAULT.equals(read))
            {
                reqMap.put(ParamKey.READ, read);
            }
            reqMap.put(ParamKey.ORGANIZATIONCODE, organizationCode);
            reqMap.put(ParamKey.SORT, sort);
            if (StringUtil.isNotBlank(blackList))
            {
                String[] domains = blackList.split(SPLIT);
                reqMap.put(ParamKey.DOMAINS, Arrays.asList(domains));
            }
            // 聚合过的总记录数
            int totalCount = this.dataBeanService.findByMapCount(reqMap);
            int totalPage = (totalCount + limit - 1) / limit;
            if (totalPage == 0)
            {
                currentPage = 1;
            }
            else if (currentPage <= 0)
            {
                currentPage = 1;
            }
            else if (currentPage > totalPage)
            {
                currentPage = totalPage;
            }
            reqMap.put(ParamKey.START, (currentPage - 1) * limit);
            reqMap.put(ParamKey.LIMIT, limit);
            List<DataBean> databeans = this.dataBeanService.findByMap(reqMap);
            
            resp.setPageNo(currentPage);
            resp.setLimit(limit);
            resp.setTotal(totalCount);
            resp.setTotalPage(totalPage);
            resp.setData(databeans);
            // 响应状态信息
            resp.setReturnCode(ReturnCode.SUCCESS);
            resp.setMessage(ReturnMessage.QUERY_SUCCESS);
            resp.setSuccess(Boolean.TRUE);
            long cost = DateUtil.getDiffTime(reqTime);
            resp.setQtime(cost);
            LOGGER.info("--------该单位{}查询请求耗时{}ms",organizationCode,cost);
            return JsonUtil.object2Str(resp);
            
        }
        
    }
    
    @Override
    public String delete(DeleteReq req)
    {
        LOGGER.info("###### batch delete records ######");
        long reqTime = System.currentTimeMillis();
        DeleteResp resp = new DeleteResp();
        
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            this.saveErrorLoggerService.save(Operator.BATCH_DELETE, ReturnMessage.PARAM_INVALID);
            return JsonUtil.object2Str(resp);
        }
        else
        {
            Map<String, Object> reqMap = new HashMap<String, Object>();
            String organizationCode = req.getOrganizationCode().trim();
            reqMap.put(ParamKey.ORGANIZATIONCODE, organizationCode);
            String ids = req.getIds();
            String[] idsStr = ids.split(SPLIT);
            List<String> idList = Arrays.asList(idsStr);
            reqMap.put(ParamKey.IDS, idList);
            
            try
            {
                this.dataBeanService.batchDeleteInfo(reqMap);
            }
            catch (Exception e)
            {
                LOGGER.error("batch delete records failed", e);
                resp.setReturnCode(ReturnCode.FAILED);
                resp.setMessage(ReturnMessage.DELET_TIP_ERROR);
                resp.setSuccess(Boolean.FALSE);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                this.saveErrorLoggerService.save(Operator.BATCH_DELETE, e.getMessage());
                return JsonUtil.object2Str(resp);
            }
            
            resp.setReturnCode(ReturnCode.SUCCESS);
            resp.setMessage(ReturnMessage.DELET_TIP_SUCCESS);
            resp.setSuccess(Boolean.TRUE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            return JsonUtil.object2Str(resp);
            
        }
    }
    
    @Override
    public String summary(SummaryReq req)
    {
        long reqTime = System.currentTimeMillis();
        SummaryResp resp = new SummaryResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setSummary(null);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            this.saveErrorLoggerService.save(Operator.SUMMAY, ReturnMessage.PARAM_INVALID);
            return JsonUtil.object2Str(resp);
        }
        else
        {
            String organizationCode = req.getOrganizationCode().trim();
            String startDate = req.getStartDate().trim();// yyyy-MM-dd
            String endDate = req.getEndDate().trim();
            
            Map<String, Object> param = new HashMap<String, Object>();
            param.put(ParamKey.ORGANIZATIONCODE, organizationCode);
            param.put(ParamKey.START_DATE, DateUtil.format(startDate));
            param.put(ParamKey.END_DATE, DateUtil.format(endDate));
            // 根据单位编码，起始日期结束日期查询t_organization_summary表
            List<OrganizationSummary> summaryList = this.organizationSummaryService.findByCondition(param);
            // 将多个对象整合成单条数据返回给接口
            OrganizationSummary summary = parseSummaryList2One(summaryList);
            try
            {
                if (summary != null)
                {
                    // 转换表中字段响应的映射
                    resp.setSummary(parseWebSiteType(summary));
                }
                else
                {
                    resp.setSummary(null);
                }
            }
            catch (Exception e)
            {
                LOGGER.error("系统内部异常", e);
                resp.setMessage(ReturnMessage.INNER_ERROR);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                resp.setReturnCode(ReturnCode.FAILED);
                resp.setSummary(null);
                resp.setSuccess(Boolean.FALSE);
                this.saveErrorLoggerService.save(Operator.SUMMAY, e.getMessage());
                return JsonUtil.object2Str(resp);
            }
            resp.setMessage(ReturnMessage.QUERY_SUCCESS);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            resp.setReturnCode(ReturnCode.SUCCESS);
            resp.setSuccess(Boolean.TRUE);
            return JsonUtil.object2Str(resp);
        }
    }
    
    /**
     * 集合转成单个对象
     * 
     * @param summaryList
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static OrganizationSummary parseSummaryList2One(List<OrganizationSummary> summaryList)
    {
        long abroad = 0l; // 境外
        long boke = 0l; // 博客
        long forum = 0l; // 论坛
        long weixin = 0l; // 微信
        long media = 0l; // 平面媒体
        long weibo = 0l; // 微博
        long news = 0l; // 新闻
        long tieba = 0l; // 贴吧
        long twitter = 0l; // twitter
        OrganizationSummary summary = new OrganizationSummary();
        for (OrganizationSummary organizationSummary : summaryList)
        {
            abroad += organizationSummary.getAbroad();
            boke += organizationSummary.getAbroad();
            forum += organizationSummary.getForum();
            weixin += organizationSummary.getWeixin();
            media += organizationSummary.getMedia();
            weibo += organizationSummary.getWeibo();
            news += organizationSummary.getNews();
            tieba += organizationSummary.getTieba();
            twitter += organizationSummary.getTwitter();
        }
        summary.setAbroad(abroad);
        summary.setBoke(boke);
        summary.setForum(forum);
        summary.setMedia(media);
        summary.setNews(news);
        summary.setTieba(tieba);
        summary.setTwitter(twitter);
        summary.setWeibo(weibo);
        summary.setWeixin(weixin);
        return summary;
    }
    
    /**
     * 转换查询的结果集
     * 
     * @param summary
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @see [类、类#方法、类#成员]
     */
    private static List<WebSiteTypeCnt> parseWebSiteType(OrganizationSummary summary)
        throws IllegalArgumentException, IllegalAccessException
    {
        // 指定大小集合
        List<WebSiteTypeCnt> webSiteList = new ArrayList<WebSiteTypeCnt>(9);
        WebSiteTypeCnt webSiteTypeCnt = null;
        Field[] fields = summary.getClass().getDeclaredFields();
        for (Field field : fields)
        {
            field.setAccessible(true);
            webSiteTypeCnt = new WebSiteTypeCnt();
            String fieldName = field.getName();
            if (!ParamKey.ORGANIZATIONCODE.equals(fieldName) && !ParamKey.RECORD_TIME.equals(fieldName))
            {
                int webSiteType = getWebSiteType(fieldName);
                webSiteTypeCnt.setWebSiteType(webSiteType);
                
                webSiteTypeCnt.setCnt(field.getLong(summary));
                webSiteList.add(webSiteTypeCnt);
            }
            
        }
        return webSiteList;
    }
    
    /**
     * 根据字段转换网站类型
     * 
     * @param fieldName
     * @return
     * @see [类、类#方法、类#成员]
     */
    private static int getWebSiteType(String fieldName)
    {
        int webSiteType = 0;
        switch (fieldName)
        {
            case "abroad":
                webSiteType = WebSiteType.ABROAD;
                break;
            case "boke":
                webSiteType = WebSiteType.BOKE;
                break;
            case "forum":
                webSiteType = WebSiteType.FORUM;
                break;
            case "media":
                webSiteType = WebSiteType.MEDIA;
                break;
            case "news":
                webSiteType = WebSiteType.NEWS;
                break;
            case "tieba":
                webSiteType = WebSiteType.TIEBA;
                break;
            case "twitter":
                webSiteType = WebSiteType.TWITTER;
                break;
            case "weibo":
                webSiteType = WebSiteType.WEIBO;
                break;
            case "weixin":
                webSiteType = WebSiteType.WEIXIN;
                break;
            default:
                break;
        }
        return webSiteType;
    }
    
}
