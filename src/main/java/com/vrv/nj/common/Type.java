package com.vrv.nj.common;

public enum Type
{
    ADD("add"), UPDATE("update"), DELETE("delete");
    private String operatorType;
    
    private Type(String operatorType)
    {
        this.operatorType = operatorType;
    }
    
    public String getOpertorType()
    {
        return operatorType;
    }
}
