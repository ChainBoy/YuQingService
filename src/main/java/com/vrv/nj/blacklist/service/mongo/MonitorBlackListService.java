package com.vrv.nj.blacklist.service.mongo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.vrv.nj.domain.mongo.MonitorBlackList;

public interface MonitorBlackListService extends Repository<MonitorBlackList, String>
{
    // 增|改
    MonitorBlackList save(MonitorBlackList blackList);
    
    // 删
    void delete(String id);
    
    void delete(MonitorBlackList entity);
    
    void delete(Iterable<MonitorBlackList> entities);
    
    void deleteAll();
    
    // 查
    MonitorBlackList findOne(String id);
    
    Page<MonitorBlackList> findAll(Pageable pageable);
    
    @Query("{organizationCode:?0}")
    Page<MonitorBlackList> findByOrganizationCodeId(String organizationCode, Pageable pageable);
    
    @Query("{websiteName:{ $regex: ?0, $options:'i' },organizationCode:?1}")
    Page<MonitorBlackList> findByWebsiteNameAndOrganizationCode(String websiteName, String organizationCode, Pageable pageable);
    
    @Query("{mainDomain:{ $regex: ?0, $options:'i' },organizationCode:?1}")
    Page<MonitorBlackList> findByWebsiteUrlAndOrganizationCode(String mainDomain, String organizationCode, Pageable pageable);
    
    @Query("{websiteName:{ $regex: ?0, $options:'i' },mainDomain:{ $regex: ?1, $options:'i' },organizationCode:?2}")
    Page<MonitorBlackList> findByWebsiteAndOrganizationCode(String websiteName, String mainDomain, String organizationCode, Pageable pageable);
    
    @Query("{mainDomain:?0,organizationCode:?1}")
    List<MonitorBlackList> findByMainDomain(String mainDomain, String organizationCode);
    
    @Query("{organizationCode:?0}")
    List<MonitorBlackList> findByOrganizationCode(String organizationCode);
    
    @Query("{id:{$ne:?0},mainDomain:?1,organizationCode:?2}")
    List<MonitorBlackList> findByMainDomainAndId(String id, String domain, String organizationCode);
    
    @Query("{websiteName:{ $regex: ?0, $options:'i' },organizationCode:?1}")
    List<MonitorBlackList> findByWebsiteNameAndOrganizationCode(String websiteName, String organizationCode);
    
    @Query("{mainDomain:{ $regex: ?0, $options:'i' },organizationCode:?1}")
    List<MonitorBlackList> findByWebsiteUrlAndOrganizationCode(String websiteUrl, String organizationCode);
    
    @Query("{websiteName:{ $regex: ?0, $options:'i' },mainDomain:{ $regex: ?1, $options:'i' },organizationCode:?2}")
    List<MonitorBlackList> findByWebsiteAndOrganizationCode(String websiteName, String websiteUrl, String organizationCode);
}
