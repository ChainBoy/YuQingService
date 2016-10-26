package com.vrv.nj.domain.es;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * ES数据类型
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月23日]
 * @see [相关类/方法]
 * @since V1.00
 */
@XmlRootElement(name = "document")
public class Document implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    // 帖子id 唯一
    private String id;
    
    // 标题
    private String title;
    
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
    
    // 采集时间
    private long addTime;
    
    // 网页级别
    private int pr;
    
    // 网站类型
    private int webSiteType;
    
    // 网址
    private String webSite;
    
    // 正负面
    private int positiveOrNegative;
    
    // 是否为境外 0：国内 1：境外 -1：全部
    private int abroad;
    
    // 扩散值
    private int spreadValue;
    
    // 回复数
    private int replay;
    
    // 浏览数
    private int view;
    
    // 重要度
    private int importanceDegree;
    
    // 舆情值
    private int opinionValue;
    
    // 敏感值
    private int sensitiveValue;
    
    private String snapshotAddress;
    
    // 区域代码
    private String administrativeId;
    
    private String titlePrint;
    
    private String titleContentPrint;
    
    // 图片
    private String img;
    
    // 情感值
    private int moodValue;
    
    // 关键词
    private String opinionwords;
    
    // uuid
    private String uuid;
    
    // 更新频率
    private int updateFrequency;
    
    // 重要度
    private int importantValue;
    
    private String suggest;
    
    // 发布月份
    private int poMonth;
    
    // 发布日期
    private int poDay;
    
    // 发布时间
    private long poHour;
    
    // 领域
    private String domain;
    
    public String getSuggest()
    {
        return suggest;
    }
    
    public void setSuggest(String suggest)
    {
        this.suggest = suggest;
    }
    
    public int getPoMonth()
    {
        return poMonth;
    }
    
    public void setPoMonth(int poMonth)
    {
        this.poMonth = poMonth;
    }
    
    public int getPoDay()
    {
        return poDay;
    }
    
    public void setPoDay(int poDay)
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
    
    public String getDomain()
    {
        return domain;
    }
    
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    
    public int getProvinceCode()
    {
        return provinceCode;
    }
    
    public void setProvinceCode(int provinceCode)
    {
        this.provinceCode = provinceCode;
    }
    
    public short getRubbish()
    {
        return rubbish;
    }
    
    public void setRubbish(short rubbish)
    {
        this.rubbish = rubbish;
    }
    
    // 省份代码
    private int provinceCode;
    
    // 是否是垃圾网站
    private short rubbish;
    
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
    
    public int getPr()
    {
        return pr;
    }
    
    public void setPr(int pr)
    {
        this.pr = pr;
    }
    
    public int getWebSiteType()
    {
        return webSiteType;
    }
    
    public void setWebSiteType(int webSiteType)
    {
        this.webSiteType = webSiteType;
    }
    
    public String getWebSite()
    {
        return webSite;
    }
    
    public void setWebSite(String webSite)
    {
        this.webSite = webSite;
    }
    
    public int getPositiveOrNegative()
    {
        return positiveOrNegative;
    }
    
    public void setPositiveOrNegative(int positiveOrNegative)
    {
        this.positiveOrNegative = positiveOrNegative;
    }
    
    public int getAbroad()
    {
        return abroad;
    }
    
    public void setAbroad(int abroad)
    {
        this.abroad = abroad;
    }
    
    public int getSpreadValue()
    {
        return spreadValue;
    }
    
    public void setSpreadValue(int spreadValue)
    {
        this.spreadValue = spreadValue;
    }
    
    public int getReplay()
    {
        return replay;
    }
    
    public void setReplay(int replay)
    {
        this.replay = replay;
    }
    
    public int getView()
    {
        return view;
    }
    
    public void setView(int view)
    {
        this.view = view;
    }
    
    public int getImportanceDegree()
    {
        return importanceDegree;
    }
    
    public void setImportanceDegree(int importanceDegree)
    {
        this.importanceDegree = importanceDegree;
    }
    
    public int getOpinionValue()
    {
        return opinionValue;
    }
    
    public void setOpinionValue(int opinionValue)
    {
        this.opinionValue = opinionValue;
    }
    
    public int getSensitiveValue()
    {
        return sensitiveValue;
    }
    
    public void setSensitiveValue(int sensitiveValue)
    {
        this.sensitiveValue = sensitiveValue;
    }
    
    public String getSnapshotAddress()
    {
        return snapshotAddress;
    }
    
    public void setSnapshotAddress(String snapshotAddress)
    {
        this.snapshotAddress = snapshotAddress;
    }
    
    public String getAdministrativeId()
    {
        return administrativeId;
    }
    
    public void setAdministrativeId(String administrativeId)
    {
        this.administrativeId = administrativeId;
    }
    
    public String getTitlePrint()
    {
        return titlePrint;
    }
    
    public void setTitlePrint(String titlePrint)
    {
        this.titlePrint = titlePrint;
    }
    
    public String getTitleContentPrint()
    {
        return titleContentPrint;
    }
    
    public void setTitleContentPrint(String titleContentPrint)
    {
        this.titleContentPrint = titleContentPrint;
    }
    
    public String getImg()
    {
        return img;
    }
    
    public void setImg(String img)
    {
        this.img = img;
    }
    
    public int getMoodValue()
    {
        return moodValue;
    }
    
    public void setMoodValue(int moodValue)
    {
        this.moodValue = moodValue;
    }
    
    public String getOpinionwords()
    {
        return opinionwords;
    }
    
    public void setOpinionwords(String opinionwords)
    {
        this.opinionwords = opinionwords;
    }
    
    public String getUuid()
    {
        return uuid;
    }
    
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    
    public int getUpdateFrequency()
    {
        return updateFrequency;
    }
    
    public void setUpdateFrequency(int updateFrequency)
    {
        this.updateFrequency = updateFrequency;
    }
    
    public int getImportantValue()
    {
        return importantValue;
    }
    
    public void setImportantValue(int importantValue)
    {
        this.importantValue = importantValue;
    }
    
}
