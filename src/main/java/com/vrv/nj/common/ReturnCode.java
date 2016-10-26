package com.vrv.nj.common;

/**
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年8月26日]
 * @category 响应状态码
 */
public interface ReturnCode
{
    /**
     * "000000" : 成功
     */
    public static final String SUCCESS = "000000";
    
    /**
     * "000001":失败
     */
    public static final String FAILED = "000001";
    
    /**
     * "200001":参数不合法
     */
    public static final String FAILED_PARAM = "200001";
}
