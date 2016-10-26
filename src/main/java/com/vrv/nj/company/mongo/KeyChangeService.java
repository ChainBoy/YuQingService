package com.vrv.nj.company.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.vrv.nj.domain.mongo.KeyChange;

public interface KeyChangeService extends Repository<KeyChange, String>
{
    // 增|改
    KeyChange save(KeyChange keyChange);
    
    @Query("{organizationCode:?0}")
    List<KeyChange> findByOrganizationCodeId(String organizationCode);
    
    void delete(String id);
}
