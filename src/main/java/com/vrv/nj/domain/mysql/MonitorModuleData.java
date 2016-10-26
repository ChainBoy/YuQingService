package com.vrv.nj.domain.mysql;

import java.io.Serializable;

public class MonitorModuleData implements Serializable
{
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String moduleId;
    
    private String title;
    
    private String content;
    
    private String url;
    
    private long poTime;
    
    private String author;
    
    private String domain;
    
    private String source;
    
    private long addTime;
    
    private int pr;
    
    private int webSiteType;
    
    private String webSite;
    
    private int positiveOrNegative;
    
    private int abroad;
    
    private int spreadValue;
    
    private int replay;
    
    private int view;
    
    private int transer;
    
    private int praiseCount;
    
    private int importanceDegree;
    
    private int opinionValue;
    
    private int sensitiveValue;
    
    private String administrativeId;
    
    private String titlePrint;
    
    private String titleContentPrint;
    
    private long subpoTime;
    
    private int subpraiseCount;
    
    private int subreplay;
    
    private int subtranser;
    
    private String organizationCode;
    
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
    
    public int getTranser()
    {
        return transer;
    }
    
    public void setTranser(int transer)
    {
        this.transer = transer;
    }
    
    public int getPraiseCount()
    {
        return praiseCount;
    }
    
    public void setPraiseCount(int praiseCount)
    {
        this.praiseCount = praiseCount;
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
    
    public String getOrganizationCode()
    {
        return organizationCode;
    }
    
    public void setOrganizationCode(String organizationCode)
    {
        this.organizationCode = organizationCode;
    }
    
    public String getDomain()
    {
        return domain;
    }
    
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    
    public String getModuleId()
    {
        return moduleId;
    }
    
    public void setModuleId(String moduleId)
    {
        this.moduleId = moduleId;
    }
}
