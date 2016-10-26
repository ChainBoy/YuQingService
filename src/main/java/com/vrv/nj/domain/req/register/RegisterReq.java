package com.vrv.nj.domain.req.register;

import com.vrv.nj.domain.req.BaseReq;

/**
 * 
 * @version [V1.00, 2016年9月1日]
 * @see [相关类/方法]
 * @category 注册请求参数
 */
public class RegisterReq extends BaseReq
{
    // 单位名称
    private String company;
    
    // 行业
    private String business;
    
    // 地址
    private String address;
    
    // 姓名
    private String name;
    
    // 身份证号码
    private String idNo;
    
    // 联系电话
    private String phone;
    
    // 邮箱
    private String email;
    
    public String getCompany()
    {
        return company;
    }
    
    public void setCompany(String company)
    {
        this.company = company;
    }
    
    public String getBusiness()
    {
        return business;
    }
    
    public void setBusiness(String business)
    {
        this.business = business;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getIdNo()
    {
        return idNo;
    }
    
    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
}
