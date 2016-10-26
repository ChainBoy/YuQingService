package com.vrv.nj.common;

public enum RequestMethod
{
    GET("Get"), POST("Post");
    
    private String method;
    
    private RequestMethod(String method)
    {
        this.method = method;
    }
    
    public String getMethod()
    {
        return method;
    }
    
    public String getValue()
    {
        return name();
    }
    
    public boolean isGet()
    {
        return GET.equals(this);
    }
    
    public boolean isPost()
    {
        return POST.equals(this);
    }
}
