package com.vrv.nj.common;

/**
 * 数据类型
 *  
 * @author  赵炎
 * @version  [V1.00, 2016年10月24日]
 * @see  [相关类/方法]
 * @since V1.00
 * @category 数据类型
 */
public enum DataType
{
    DOCUMENT("document"), WEIBO("weibo");
    
    private String dataType;
    
    private DataType(String dataType)
    {
        this.dataType = dataType;
    }
    
    public String getDataType()
    {
        return dataType;
    }
}
