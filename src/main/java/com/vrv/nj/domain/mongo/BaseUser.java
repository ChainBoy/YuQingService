package com.vrv.nj.domain.mongo;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T200_BaseUser")
public class BaseUser
{
    
    @Id
    private String id;
    
    private String username;
    
    private String realname;
    
    private String password;
    
    private String position;
    
    private String department;
    
    private String organizationCode;
    
    private String phone;
    
    private String email;
    
    private Integer status;
    
    private Integer active;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Date lastloginTime;
    
    private String roleId;
    
    private Set<String> attendBaseInfoIds;// 不保存重复贴子
    
    private Set<String> favorityBaseInfoIds;// 不保存重复贴子
    
    private String homeSettingId;
    
    private String qq;
    
    private String alertPhone;
    
    private boolean isOpen;
    
    private Set<String> attendWebsite;// 不保存重复网站
    
    private Set<String> attendAuthor;// 不保存重复作者
    
    private int loginError;
    
    private String usbKeyUuid = "";
    
    /* user defind */
    private String createTimeString;
    
    private String updateTimeString;
    
    private String lastloginTimeString;
    
    private boolean isSuperAdmin;
    
    private String facePhotoStr;
    
    private String defaultTopic; // 首页默认的专题
    
    @Transient
    private String organization;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getFacePhotoStr()
    {
        return facePhotoStr;
    }
    
    public void setFacePhotoStr(String facePhotoStr)
    {
        this.facePhotoStr = facePhotoStr;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getRealname()
    {
        return realname;
    }
    
    public void setRealname(String realname)
    {
        this.realname = realname;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public void setPosition(String position)
    {
        this.position = position;
    }
    
    public String getDepartment()
    {
        return department;
    }
    
    public void setDepartment(String department)
    {
        this.department = department;
    }
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
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
    
    public Integer getStatus()
    {
        return status;
    }
    
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
    public Integer getActive()
    {
        return active;
    }
    
    public void setActive(Integer active)
    {
        this.active = active;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public Date getLastloginTime()
    {
        return lastloginTime;
    }
    
    public void setLastloginTime(Date lastloginTime)
    {
        this.lastloginTime = lastloginTime;
    }
    
    public String getRoleId()
    {
        return roleId;
    }
    
    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }
    
    public String getHomeSettingId()
    {
        return homeSettingId;
    }
    
    public void setHomeSettingId(String homeSettingId)
    {
        this.homeSettingId = homeSettingId;
    }
    
    public String getQq()
    {
        return qq;
    }
    
    public void setQq(String qq)
    {
        this.qq = qq;
    }
    
    public String getAlertPhone()
    {
        return alertPhone;
    }
    
    public void setAlertPhone(String alertPhone)
    {
        this.alertPhone = alertPhone;
    }
    
    public boolean isOpen()
    {
        return isOpen;
    }
    
    public void setOpen(boolean isOpen)
    {
        this.isOpen = isOpen;
    }
    
    public Set<String> getAttendBaseInfoIds()
    {
        return attendBaseInfoIds;
    }
    
    public void setAttendBaseInfoIds(Set<String> attendBaseInfoIds)
    {
        this.attendBaseInfoIds = attendBaseInfoIds;
    }
    
    public Set<String> getFavorityBaseInfoIds()
    {
        return favorityBaseInfoIds;
    }
    
    public void setFavorityBaseInfoIds(Set<String> favorityBaseInfoIds)
    {
        this.favorityBaseInfoIds = favorityBaseInfoIds;
    }
    
    public Set<String> getAttendWebsite()
    {
        return attendWebsite;
    }
    
    public void setAttendWebsite(Set<String> attendWebsite)
    {
        this.attendWebsite = attendWebsite;
    }
    
    public Set<String> getAttendAuthor()
    {
        return attendAuthor;
    }
    
    public void setAttendAuthor(Set<String> attendAuthor)
    {
        this.attendAuthor = attendAuthor;
    }
    
    public int getLoginError()
    {
        return loginError;
    }
    
    public void setLoginError(int loginError)
    {
        this.loginError = loginError;
    }
    
    public String getCreateTimeString()
    {
        return createTimeString;
    }
    
    public void setCreateTimeString(String createTimeString)
    {
        this.createTimeString = createTimeString;
    }
    
    public String getUpdateTimeString()
    {
        return updateTimeString;
    }
    
    public void setUpdateTimeString(String updateTimeString)
    {
        this.updateTimeString = updateTimeString;
    }
    
    public String getLastloginTimeString()
    {
        return lastloginTimeString;
    }
    
    public void setLastloginTimeString(String lastloginTimeString)
    {
        this.lastloginTimeString = lastloginTimeString;
    }
    
    public String getOrganization()
    {
        return organization;
    }
    
    public void setOrganization(String organization)
    {
        this.organization = organization;
    }
    
    public boolean isSuperAdmin()
    {
        return isSuperAdmin;
    }
    
    public void setSuperAdmin(boolean isSuperAdmin)
    {
        this.isSuperAdmin = isSuperAdmin;
    }
    
    public String getUsbKeyUuid()
    {
        return usbKeyUuid;
    }
    
    public void setUsbKeyUuid(String usbKeyUuid)
    {
        this.usbKeyUuid = usbKeyUuid;
    }
    
    public String getDefaultTopic()
    {
        return defaultTopic;
    }
    
    public void setDefaultTopic(String defaultTopic)
    {
        this.defaultTopic = defaultTopic;
    }
    
}
