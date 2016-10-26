package com.vrv.nj.blacklist;

import com.vrv.nj.domain.mysql.BlackList;

public interface IBlackListService
{
    BlackList findByPK(String id);
    
    void deleleByPK(String id);
    
    void updateOne(BlackList black);
    
    void saveOne(BlackList black);
}
