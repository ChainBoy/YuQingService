package com.vrv.nj.user.mongo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import com.vrv.nj.domain.mongo.BaseUser;

public interface BaseUserService extends Repository<BaseUser, String>
{
    
    // 增|改
    BaseUser save(BaseUser baseUser);
    
    Iterable<BaseUser> save(Iterable<BaseUser> entities);
    
    // 删
    void delete(String id);
    
    void delete(BaseUser entity);
    
    void delete(Iterable<BaseUser> entities);
    
    void deleteAll();
    
    // 查
    BaseUser findOne(String id);
    
    Iterable<BaseUser> findAll(Iterable<String> ids);
    
    Iterable<BaseUser> findAll();
    
    @Query(value = "{organizationCode:?0,isSuperAdmin:?1}")
    Iterable<BaseUser> findAllByOrganizationCode(String organizationCode, boolean isSuperAdmin);
    
    Iterable<BaseUser> findAll(Sort sort);
    
    Page<BaseUser> findAll(Pageable pageable);
    
    long count();
    
    boolean exists(String id);
    
    @Query(value = "{username:?0}")
    List<BaseUser> findBaseUserByUsername(String username);
    
    @Query(value = "{usbKeyUuid:?0}")
    List<BaseUser> findBaseUserByUsbKeyUuid(String usbKeyUuid);
    
    @Query(value = "{username: {$regex:?0},organizationCode:?1 , isSuperAdmin: ?2}")
    List<BaseUser> findBaseUserByUsernameOrganization(String username, String organizationCode, boolean isSuperAdmin);
    
    @Query("{organizationCode:?0,isSuperAdmin: ?1}")
    List<BaseUser> findByOrganizationCode(String organizationCode, boolean isSuperAdmin);
    
    @Query("{username:{ $regex: ?0 }}")
    Page<BaseUser> findMongoBeanLike(String search, Pageable pageable);
    
    @Query("{organizationCode:?0}")
    List<BaseUser> findByOrganizationCode(String organizationCode);
    
    @Query("{organizationCode:?0 ,isSuperAdmin: ?1}")
    Page<BaseUser> findByOrganizationCode(String organizationCode, boolean isSuperAdmin, Pageable pageable);

}
