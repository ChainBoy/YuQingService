package com.vrv.nj.company.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.common.ReturnCode;
import com.vrv.nj.common.ReturnMessage;
import com.vrv.nj.company.mongo.KeyChangeService;
import com.vrv.nj.company.mongo.MonitorKeyService;
import com.vrv.nj.company.service.ICompanyService;
import com.vrv.nj.company.service.IOrganizaitonMsgService;
import com.vrv.nj.domain.JsonKeyBean;
import com.vrv.nj.domain.mongo.KeyChange;
import com.vrv.nj.domain.mongo.MonitorKey;
import com.vrv.nj.domain.mysql.OrganizationMsg;
import com.vrv.nj.domain.req.company.DeleteReq;
import com.vrv.nj.domain.req.company.UpdateKeywordsReq;
import com.vrv.nj.domain.req.company.UpdateOrgMsgReq;
import com.vrv.nj.domain.resp.company.DeleteResp;
import com.vrv.nj.domain.resp.company.LoadAllDataResp;
import com.vrv.nj.domain.resp.company.UpdateKeywordsResp;
import com.vrv.nj.domain.resp.company.UpdateOrgMsgResp;
import com.vrv.nj.util.DateUtil;
import com.vrv.nj.util.JsonUtil;
import com.vrv.nj.util.ParamValidator;
import com.vrv.nj.util.WordsUtil;

/**
 * 单位信息服务
 * 
 * @author 赵炎
 * @version [V1.00, 2016年9月30日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 单位信息服务实现
 */
@Service("companyService")
public class CompanyServiceImpl implements ICompanyService
{
    @Autowired
    private IOrganizaitonMsgService organizationMsgService;
    
    @Autowired
    private KeyChangeService keyChangeService;
    
    @Autowired
    private MonitorKeyService monitorKeyService;
    
    @Override
    public String updateKeyWordsTask(UpdateKeywordsReq req)
    {
        long reqTime = System.currentTimeMillis();
        UpdateKeywordsResp resp = new UpdateKeywordsResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            return JsonUtil.object2Str(resp);
        }
        else
        {
            // 单位编码
            String organizationCode = req.getOrganizationCode().trim();
            // 该单位关键词更新列表
            List<KeyChange> keyChangelist = this.keyChangeService.findByOrganizationCodeId(organizationCode);
            // 根据单位编码查询单位信息
            OrganizationMsg organizationMsg = this.organizationMsgService.findByOrganizationCode(organizationCode);
            
            List<MonitorKey> monitorKeys = null;
            List<JsonKeyBean> subCategory = new ArrayList<JsonKeyBean>();
            if (keyChangelist != null && keyChangelist.size() > 0)
            {
                KeyChange keyChange = null;
                if (keyChangelist.size() > 1)
                {
                    keyChange = keyChangelist.get(keyChangelist.size() - 1);
                    for (int i = 0; i <= keyChangelist.size() - 2; i++)
                    {
                        this.keyChangeService.delete(keyChangelist.get(i).getId());
                    }
                }
                else
                {
                    keyChange = keyChangelist.get(0);
                }
                // 查询出该单位修改的关键词
                monitorKeys = this.monitorKeyService.findByOrganizationCodeId(organizationCode);
                if (null != monitorKeys && monitorKeys.size() > 0)
                {
                    for (MonitorKey monitorKey : monitorKeys)
                    {
                        
                        JsonKeyBean jsonkey = null;
                        String wordstr = monitorKey.getKeyExpression();
                        if (wordstr != null && wordstr.trim().length() > 0)
                        {
                            String rsgixstr = WordsUtil.parseESTerm(wordstr);
                            if (rsgixstr.trim().length() > 0)
                            {
                                jsonkey = new JsonKeyBean();
                                jsonkey.setQ(rsgixstr);
                                jsonkey.setScope(-1);
                                subCategory.add(jsonkey);
                            }
                        }
                    }
                    // 关键词
                    JSONArray jsonArray = null;
                    jsonArray = JSONArray.fromObject(subCategory);
                    organizationMsg.setSubcategory(jsonArray.toString());
                    organizationMsg.setLastQueryTime(DateUtil.getNextDay(new Date()));
                    organizationMsg.setQueue_status(0);
                    try
                    {
                        this.organizationMsgService.save(organizationMsg);
                    }
                    catch (Exception e)
                    {
                        resp.setReturnCode(ReturnCode.FAILED);
                        resp.setMessage(ReturnMessage.UPDATE_FAILED);
                        resp.setSuccess(Boolean.FALSE);
                        resp.setQtime(DateUtil.getDiffTime(reqTime));
                        return JsonUtil.object2Str(resp);
                    }
                }
                else
                {
                    resp.setReturnCode(ReturnCode.SUCCESS);
                    resp.setMessage(ReturnMessage.NO_KEY_CHANGE);
                    resp.setSuccess(Boolean.TRUE);
                    resp.setQtime(DateUtil.getDiffTime(reqTime));
                    return JsonUtil.object2Str(resp);
                }
                try
                {
                    this.keyChangeService.delete(keyChange.getId());
                }
                catch (Exception e)
                {
                    resp.setReturnCode(ReturnCode.FAILED);
                    resp.setMessage(ReturnMessage.UPDATE_FAILED);
                    resp.setSuccess(Boolean.FALSE);
                    resp.setQtime(DateUtil.getDiffTime(reqTime));
                    return JsonUtil.object2Str(resp);
                }
                resp.setReturnCode(ReturnCode.SUCCESS);
                resp.setMessage(ReturnMessage.UPDATE_SUCCESS);
                resp.setSuccess(Boolean.TRUE);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                return JsonUtil.object2Str(resp);
            }
            else
            {
                resp.setReturnCode(ReturnCode.SUCCESS);
                resp.setMessage(ReturnMessage.NO_KEY_CHANGE);
                resp.setSuccess(Boolean.TRUE);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                return JsonUtil.object2Str(resp);
            }
        }
    }
    
    @Override
    public String loadAllData()
    {
        long reqTime = System.currentTimeMillis();
        LoadAllDataResp resp = new LoadAllDataResp();
        List<OrganizationMsg> orgs = this.organizationMsgService.findAll();
        resp.setData(orgs);
        resp.setQtime(DateUtil.getDiffTime(reqTime));
        resp.setReturnCode(ReturnCode.SUCCESS);
        resp.setSuccess(Boolean.TRUE);
        resp.setMessage(ReturnMessage.QUERY_SUCCESS);
        return JsonUtil.object2Str(resp);
    }
    
    @Override
    public String updateOrgMsg(UpdateOrgMsgReq req)
    {
        long reqTime = System.currentTimeMillis();
        UpdateOrgMsgResp resp = new UpdateOrgMsgResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            return JsonUtil.object2Str(resp);
        }
        else
        {
            String organizationCode = req.getOrganizationCode().trim();
            int pretreatment = Integer.parseInt(req.getPretreatment().trim());
            OrganizationMsg organizationMsg = this.organizationMsgService.findByOrganizationCode(organizationCode);
            if (organizationMsg == null)
            {
                resp.setReturnCode(ReturnCode.FAILED);
                resp.setMessage(ReturnMessage.NO_EXIST_ORG);
                resp.setSuccess(Boolean.FALSE);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                return JsonUtil.object2Str(resp);
            }
            else
            {
                organizationMsg.setPretreatment(pretreatment);
                try
                {
                    this.organizationMsgService.save(organizationMsg);
                }
                catch (Exception e)
                {
                    resp.setReturnCode(ReturnCode.FAILED);
                    resp.setMessage(ReturnMessage.UPDATE_FAILED);
                    resp.setSuccess(Boolean.FALSE);
                    resp.setQtime(DateUtil.getDiffTime(reqTime));
                    return JsonUtil.object2Str(resp);
                }
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                resp.setReturnCode(ReturnCode.SUCCESS);
                resp.setSuccess(Boolean.TRUE);
                resp.setMessage(ReturnMessage.UPDATE_ORG_SUCCESS);
                return JsonUtil.object2Str(resp);
            }
        }
    }
    
    @Override
    public String delete(DeleteReq req)
    {
        long reqTime = System.currentTimeMillis();
        DeleteResp resp = new DeleteResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            return JsonUtil.object2Str(resp);
        }
        else
        {
            String organizationCode = req.getOrganizationCode().trim();
            try
            {
                this.organizationMsgService.deleteOne(organizationCode);
            }
            catch (Exception e)
            {
                resp.setReturnCode(ReturnCode.FAILED);
                resp.setMessage(ReturnMessage.DELET_ORG_ERROR);
                resp.setSuccess(Boolean.FALSE);
                resp.setQtime(DateUtil.getDiffTime(reqTime));
                return JsonUtil.object2Str(resp);
            }
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            resp.setReturnCode(ReturnCode.SUCCESS);
            resp.setSuccess(Boolean.TRUE);
            resp.setMessage(ReturnMessage.DELET_ORG_SUCCESS);
            return JsonUtil.object2Str(resp);
        }
    }
    
}
