package com.vrv.nj.mapper;

import org.apache.ibatis.annotations.Param;

import com.vrv.nj.domain.mysql.BlackList;

public interface BlackListMapper
{
    void saveOne(BlackList black);
    
    void updateOne(BlackList black);
    
    BlackList findByPK(@Param("id") String id);
    
    void deleteByPK(@Param("id") String id);
    
}
