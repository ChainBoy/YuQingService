package com.vrv.nj.domain.req.login.web;

import com.vrv.nj.domain.req.BaseReq;

/**
 * 登录请求
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月25日]
 * @category web端登录请求
 */
public class LoginWebReq extends BaseReq
{
    private String username;
    
    private String password;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
}
