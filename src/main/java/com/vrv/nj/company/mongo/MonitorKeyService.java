package com.vrv.nj.company.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.vrv.nj.domain.mongo.MonitorKey;

public interface MonitorKeyService extends Repository<MonitorKey, String>
{
    // 增|改
    MonitorKey save(MonitorKey monitorCategory);
    
    Iterable<MonitorKey> save(Iterable<MonitorKey> entities);
    
    // 删
    void delete(String id);
    
    void delete(MonitorKey entity);
    
    void delete(Iterable<MonitorKey> entities);
    
    void deleteAll();
    
    // 查
    MonitorKey findOne(String id);
    
    Iterable<MonitorKey> findAll(Iterable<String> ids);
    
    Iterable<MonitorKey> findAll();
    
    Iterable<MonitorKey> findAll(Sort sort);
    
    Page<MonitorKey> findAll(Pageable pageable);
    
    @Query("{organizationCode:?0}")
    Page<MonitorKey> findByOrganizationCode(String organizationCode, Pageable pageable);
    
    long count();
    
    boolean exists(String id);
    
    @Query("{username:{ $regex: }")
    List<MonitorKey> findT200_MonitorKeyLike(String like, String xxx);
    
    @Query("{userId:?0,organizationCode:?1,monitorType:?2,monitorScope:?3,keyExpression:?4}")
    MonitorKey findData(String userId, String organizationCode, int monitorType, int monitorScope, String keyword);
    
    @Query("{organizationCode:?0}")
    Iterable<MonitorKey> findByOrganizationCode(String organizationCode);
    
    @Query("{keyExpression:{ $regex: ?0, $options:'i' },organizationCode:?1}")
    List<MonitorKey> findByQueryValue(String queryValue, String organizationCode);
    
    @Query("{$or:[{keyName:{ $regex: ?0, $options:'i' }},{keyExpression:{ $regex: ?1, $options:'i' }}],organizationCode:?2}")
    Page<MonitorKey> findByQueryValue(String keyName, String queryValue, String organizationCode, Pageable page);
    
    @Query("{organizationCode:?0}")
    List<MonitorKey> findByOrganizationCodeId(String organizationCode);
    
    @Query("{organizationCode:?0}")
    Page<MonitorKey> findByOrganizationCodeId(String organizationCode, Pageable page);
    
    @Query(value = "{'categoryIds': ?0  }")
    List<MonitorKey> findByCategoryIds(String cate);
    
    @Query(value = "{'keyExpression':{$regex: ?0},'organizationCode':?1}")
    List<MonitorKey> findByWord(String word, String organizationCode);
    
    @Query("{'userId':?0,'categoryIds':{'$in':[?1]}}")
    List<MonitorKey> findByUserIdAndCategoryId(String userId, String categoryId);
    
    @Query("{userId:?0,organizationCode:?1,categoryIds:{'$in':[?2]}}")
    Page<MonitorKey> findByCategoryId(String userId, String organizationCode, String categoryId, Pageable page);
    
    @Query("{userId:?0,organizationCode:?1,keyName:?2,keyExpression:?3}")
    MonitorKey findByKeyWord(String userId, String organizationCode, String keyName, String keyWord);
    
    @Query("{userId:?0,organizationCode:?1}")
    List<MonitorKey> findByUserIdAndOrganizationCode(String userId, String organizationCode);
    
    @Query("{'organizationCode':?0,'categoryIds':{'$in':[?1]}}")
    List<MonitorKey> findByOrganizationCodeAndCategoryId(String organizationCode, String fenleiid);
}
