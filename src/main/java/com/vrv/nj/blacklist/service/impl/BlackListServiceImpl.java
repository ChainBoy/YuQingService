package com.vrv.nj.blacklist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrv.nj.blacklist.IBlackListService;
import com.vrv.nj.domain.mysql.BlackList;
import com.vrv.nj.mapper.BlackListMapper;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年10月25日]
 * @see [相关类/方法]
 * @since V1.00
 */
@Service("blackListService")
public class BlackListServiceImpl implements IBlackListService
{
    @Autowired
    private BlackListMapper blackListMapper;
    
    @Override
    public BlackList findByPK(String id)
    {
        return this.blackListMapper.findByPK(id);
    }
    
    @Override
    public void deleleByPK(String id)
    {
        this.blackListMapper.deleteByPK(id);
    }
    
    @Override
    public void updateOne(BlackList black)
    {
        this.blackListMapper.updateOne(black);
    }
    
    @Override
    public void saveOne(BlackList black)
    {
        this.blackListMapper.saveOne(black);
    }
    
}
