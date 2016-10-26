package com.vrv.nj.domain.mysql;

import java.util.Date;

public class OrganizationSummary
{
    private String organizationCode;
    
    private Date record_time;// 记录时间
    
    private long abroad;// 境外
    
    private long boke;// 博客
    
    private long forum;// 论坛
    
    private long media;// 平面媒体
    
    private long news;// 新闻
    
    private long tieba;// 贴吧
    
    private long twitter;// twitter
    
    private long weibo;// 微博
    
    private long weixin;// 微信
    
    public Date getRecord_time()
    {
        return record_time;
    }
    
    public void setRecord_time(Date record_time)
    {
        this.record_time = record_time;
    }
    
    public long getAbroad()
    {
        return abroad;
    }
    
    public void setAbroad(long abroad)
    {
        this.abroad = abroad;
    }
    
    public long getBoke()
    {
        return boke;
    }
    
    public void setBoke(long boke)
    {
        this.boke = boke;
    }
    
    public long getForum()
    {
        return forum;
    }
    
    public void setForum(long forum)
    {
        this.forum = forum;
    }
    
    public long getMedia()
    {
        return media;
    }
    
    public void setMedia(long media)
    {
        this.media = media;
    }
    
    public long getNews()
    {
        return news;
    }
    
    public void setNews(long news)
    {
        this.news = news;
    }
    
    public long getTieba()
    {
        return tieba;
    }
    
    public void setTieba(long tieba)
    {
        this.tieba = tieba;
    }
    
    public long getTwitter()
    {
        return twitter;
    }
    
    public void setTwitter(long twitter)
    {
        this.twitter = twitter;
    }
    
    public long getWeibo()
    {
        return weibo;
    }
    
    public void setWeibo(long weibo)
    {
        this.weibo = weibo;
    }
    
    public long getWeixin()
    {
        return weixin;
    }
    
    public void setWeixin(long weixin)
    {
        this.weixin = weixin;
    }
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
}
