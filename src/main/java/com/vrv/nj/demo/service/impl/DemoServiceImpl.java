package com.vrv.nj.demo.service.impl;

import org.springframework.stereotype.Service;

import com.vrv.nj.demo.service.IDemoService;


/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月11日]
 * @see [相关类/方法]
 * @since V1.00
 * @category 测试cxf
 */
@Service("demoService")
public class DemoServiceImpl implements IDemoService
{
    
    @Override
    public String test()
    {
        return "test";
    }
    
}
