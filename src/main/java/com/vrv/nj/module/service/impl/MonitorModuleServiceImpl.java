package com.vrv.nj.module.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.common.Operator;
import com.vrv.nj.common.ParamKey;
import com.vrv.nj.common.ReturnCode;
import com.vrv.nj.common.ReturnMessage;
import com.vrv.nj.domain.mysql.MonitorModuleData;
import com.vrv.nj.domain.req.module.LoadCategoryReq;
import com.vrv.nj.domain.resp.module.LoadCategoryResp;
import com.vrv.nj.info.service.ISaveErrorLoggerService;
import com.vrv.nj.module.service.IMonitorModuleDataService;
import com.vrv.nj.module.service.IMonitorModuleService;
import com.vrv.nj.util.DateUtil;
import com.vrv.nj.util.JsonUtil;
import com.vrv.nj.util.ParamValidator;

/**
 * 首页模块服务
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月12日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 首页模块服务
 */
@Service("monitorModuleService")
public class MonitorModuleServiceImpl implements IMonitorModuleService
{
    @Autowired
    private IMonitorModuleDataService monitorModuleDataService;
    
    @Autowired
    private ISaveErrorLoggerService saveErrorLoggerService;
    
    @Override
    public String loadCategory(LoadCategoryReq req)
    {
        long reqTime = System.currentTimeMillis();
        LoadCategoryResp resp = new LoadCategoryResp();
        if (!ParamValidator.validateParam(req))
        {
            resp.setReturnCode(ReturnCode.FAILED);
            resp.setMessage(ReturnMessage.PARAM_INVALID);
            resp.setSuccess(Boolean.FALSE);
            resp.setData(null);
            resp.setTotal(0);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            this.saveErrorLoggerService.save(Operator.LOAD_DATA, ReturnMessage.PARAM_INVALID);
            return JsonUtil.object2Str(resp);
        }
        else
        {
            Map<String, Object> paraMap = new HashMap<String, Object>();
            String moduleId = req.getModuleId().trim();
            
            paraMap.put(ParamKey.MODULEID, moduleId);
            long startPoTime = DateUtil.getBeginLongDate();// 开始long型时间
            paraMap.put(ParamKey.STARTPOTIME, startPoTime);
            long endPoTime = DateUtil.getEndLongDate();// 结束long型时间
            paraMap.put(ParamKey.ENDPOTIME, endPoTime);
            List<MonitorModuleData> datas = this.monitorModuleDataService.findByModuleId(paraMap);
            long total = this.monitorModuleDataService.count(paraMap);
            resp.setReturnCode(ReturnCode.SUCCESS);
            resp.setMessage(ReturnMessage.QUERY_SUCCESS);
            resp.setSuccess(Boolean.TRUE);
            resp.setData(datas);
            resp.setTotal(total);
            resp.setQtime(DateUtil.getDiffTime(reqTime));
            return JsonUtil.object2Str(resp);
        }
        
    }
}
