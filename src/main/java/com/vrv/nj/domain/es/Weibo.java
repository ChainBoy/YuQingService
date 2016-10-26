package com.vrv.nj.domain.es;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "weibo")
public class Weibo implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    // id 唯一性
    private String id;
    
    // 标题
    private String title;
    
    private String titleContentPrint;
    
    private String titlePrint;
    
    // 舆情值
    private int opinionValue;
    
    // 正负面
    private int positiveOrNegative;
    
    // 情感值
    private int moodValue;
    
    // 扩散值
    private int spreadValue;
    
    // 敏感值
    private int sensitiveValue;
    
    // 领域
    private String domain;
    
    // 发布月份
    private long poMonth;
    
    // 发布日期
    private long poDay;
    
    // 发布时间
    private long poHour;
    
    // 省份代码
    private int provinceCode;
    
    private String opinionwords;
    
    // 内容
    private String content;
    
    // url
    private String url;
    
    // 发布时间
    private long poTime;
    
    // 作者
    private String author;
    
    // 来源
    private String source;
    
    // 添加时间
    private long addTime;
    
    // 转发量
    private int transer;
    
    // 回复数
    private int replay;
    
    // 点赞数
    private int praiseCount;
    
    // 图片
    private String img;
    
    // 短url
    private String shorturl;
    
    // 引用作者
    private String subauthor;
    
    // 引用内容
    private String subcontent;
    
    // 引用图片
    private String subimg;
    
    // 引用发布时间
    private long subpoTime;
    
    // 引用点赞数
    private int subpraiseCount;
    
    // 引用回复数
    private int subreplay;
    
    // 引用转发数
    private int subtranser;
    
    // 引用url
    private String suburl;
    
    // 引用短url
    private String subshorturl;
    
    // 网页级别
    private int pr;
    
    // 区位码
    private String administrativeId;
    
    // 重要度
    private int importanceDegree;
    
    // 简介
    private String snapshotAddress;
    
    // 网址
    private String webSite;
    
    // 作者头像url
    private String authorImgUrl;
    
    // 引用作者头像url
    private String subauthorImgUrl;
    
    // uuid
    private String uuid;
    
    //
    private int importantValue;
    
    // 更新频率
    private int updateFrequency;
    
    // 网站类型
    private int webSiteType;
    
    // 是否为境外 0：国内 1：境外 -1：全部
    private int abroad;
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public String getUrl()
    {
        return url;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public long getPoTime()
    {
        return poTime;
    }
    
    public void setPoTime(long poTime)
    {
        this.poTime = poTime;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public String getSource()
    {
        return source;
    }
    
    public void setSource(String source)
    {
        this.source = source;
    }
    
    public long getAddTime()
    {
        return addTime;
    }
    
    public void setAddTime(long addTime)
    {
        this.addTime = addTime;
    }
    
    public int getTranser()
    {
        return transer;
    }
    
    public void setTranser(int transer)
    {
        this.transer = transer;
    }
    
    public int getReplay()
    {
        return replay;
    }
    
    public void setReplay(int replay)
    {
        this.replay = replay;
    }
    
    public int getPraiseCount()
    {
        return praiseCount;
    }
    
    public void setPraiseCount(int praiseCount)
    {
        this.praiseCount = praiseCount;
    }
    
    public String getImg()
    {
        return img;
    }
    
    public void setImg(String img)
    {
        this.img = img;
    }
    
    public String getShorturl()
    {
        return shorturl;
    }
    
    public void setShorturl(String shorturl)
    {
        this.shorturl = shorturl;
    }
    
    public String getSubauthor()
    {
        return subauthor;
    }
    
    public void setSubauthor(String subauthor)
    {
        this.subauthor = subauthor;
    }
    
    public String getSubcontent()
    {
        return subcontent;
    }
    
    public void setSubcontent(String subcontent)
    {
        this.subcontent = subcontent;
    }
    
    public String getSubimg()
    {
        return subimg;
    }
    
    public void setSubimg(String subimg)
    {
        this.subimg = subimg;
    }
    
    public long getSubpoTime()
    {
        return subpoTime;
    }
    
    public void setSubpoTime(long subpoTime)
    {
        this.subpoTime = subpoTime;
    }
    
    public int getSubpraiseCount()
    {
        return subpraiseCount;
    }
    
    public void setSubpraiseCount(int subpraiseCount)
    {
        this.subpraiseCount = subpraiseCount;
    }
    
    public int getSubreplay()
    {
        return subreplay;
    }
    
    public void setSubreplay(int subreplay)
    {
        this.subreplay = subreplay;
    }
    
    public int getSubtranser()
    {
        return subtranser;
    }
    
    public void setSubtranser(int subtranser)
    {
        this.subtranser = subtranser;
    }
    
    public String getSuburl()
    {
        return suburl;
    }
    
    public void setSuburl(String suburl)
    {
        this.suburl = suburl;
    }
    
    public String getSubshorturl()
    {
        return subshorturl;
    }
    
    public void setSubshorturl(String subshorturl)
    {
        this.subshorturl = subshorturl;
    }
    
    public int getPr()
    {
        return pr;
    }
    
    public void setPr(int pr)
    {
        this.pr = pr;
    }
    
    public String getAdministrativeId()
    {
        return administrativeId;
    }
    
    public void setAdministrativeId(String administrativeId)
    {
        this.administrativeId = administrativeId;
    }
    
    public int getImportanceDegree()
    {
        return importanceDegree;
    }
    
    public void setImportanceDegree(int importanceDegree)
    {
        this.importanceDegree = importanceDegree;
    }
    
    public String getSnapshotAddress()
    {
        return snapshotAddress;
    }
    
    public void setSnapshotAddress(String snapshotAddress)
    {
        this.snapshotAddress = snapshotAddress;
    }
    
    public String getWebSite()
    {
        return webSite;
    }
    
    public void setWebSite(String webSite)
    {
        this.webSite = webSite;
    }
    
    public String getAuthorImgUrl()
    {
        return authorImgUrl;
    }
    
    public void setAuthorImgUrl(String authorImgUrl)
    {
        this.authorImgUrl = authorImgUrl;
    }
    
    public String getSubauthorImgUrl()
    {
        return subauthorImgUrl;
    }
    
    public void setSubauthorImgUrl(String subauthorImgUrl)
    {
        this.subauthorImgUrl = subauthorImgUrl;
    }
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
    public int getImportantValue()
    {
        return importantValue;
    }
    
    public void setImportantValue(int importantValue)
    {
        this.importantValue = importantValue;
    }
    
    public int getUpdateFrequency()
    {
        return updateFrequency;
    }
    
    public void setUpdateFrequency(int updateFrequency)
    {
        this.updateFrequency = updateFrequency;
    }
    
    public int getWebSiteType()
    {
        return webSiteType;
    }
    
    public void setWebSiteType(int webSiteType)
    {
        this.webSiteType = webSiteType;
    }
    
    public int getAbroad()
    {
        return abroad;
    }
    
    public void setAbroad(int abroad)
    {
        this.abroad = abroad;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getTitleContentPrint()
    {
        return titleContentPrint;
    }
    
    public void setTitleContentPrint(String titleContentPrint)
    {
        this.titleContentPrint = titleContentPrint;
    }
    
    public String getTitlePrint()
    {
        return titlePrint;
    }
    
    public void setTitlePrint(String titlePrint)
    {
        this.titlePrint = titlePrint;
    }
    
    public int getOpinionValue()
    {
        return opinionValue;
    }
    
    public void setOpinionValue(int opinionValue)
    {
        this.opinionValue = opinionValue;
    }
    
    public int getPositiveOrNegative()
    {
        return positiveOrNegative;
    }
    
    public void setPositiveOrNegative(int positiveOrNegative)
    {
        this.positiveOrNegative = positiveOrNegative;
    }
    
    public int getMoodValue()
    {
        return moodValue;
    }
    
    public void setMoodValue(int moodValue)
    {
        this.moodValue = moodValue;
    }
    
    public int getSpreadValue()
    {
        return spreadValue;
    }
    
    public void setSpreadValue(int spreadValue)
    {
        this.spreadValue = spreadValue;
    }
    
    public int getSensitiveValue()
    {
        return sensitiveValue;
    }
    
    public void setSensitiveValue(int sensitiveValue)
    {
        this.sensitiveValue = sensitiveValue;
    }
    
    public String getDomain()
    {
        return domain;
    }
    
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    
    public long getPoMonth()
    {
        return poMonth;
    }
    
    public void setPoMonth(long poMonth)
    {
        this.poMonth = poMonth;
    }
    
    public long getPoDay()
    {
        return poDay;
    }
    
    public void setPoDay(long poDay)
    {
        this.poDay = poDay;
    }
    
    public long getPoHour()
    {
        return poHour;
    }
    
    public void setPoHour(long poHour)
    {
        this.poHour = poHour;
    }
    
    public int getProvinceCode()
    {
        return provinceCode;
    }
    
    public void setProvinceCode(int provinceCode)
    {
        this.provinceCode = provinceCode;
    }
    
    public String getOpinionwords()
    {
        return opinionwords;
    }
    
    public void setOpinionwords(String opinionwords)
    {
        this.opinionwords = opinionwords;
    }
    
}
