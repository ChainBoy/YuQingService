package com.vrv.nj.domain.ip;

import java.io.Serializable;

public class TaoBaoResp implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;
    
    public int getCode()
    {
        return code;
    }
    
    public void setCode(int code)
    {
        this.code = code;
    }
    
    public Data getData()
    {
        return data;
    }
    
    public void setData(Data data)
    {
        this.data = data;
    }
    
    private int code;
    
    private Data data;
}
