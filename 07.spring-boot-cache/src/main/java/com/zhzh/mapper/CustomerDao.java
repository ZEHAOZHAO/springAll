package com.zhzh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @Author: jason.zhao
 * @date:2019/4/12 17:15
 * @Description:
 */
@Repository
@Mapper
@CacheConfig(cacheNames = "Customer")
public interface CustomerDao {
    @Cacheable()
    public Integer count();
    @Cacheable("#id")
    Customer queryById(Integer id);

    @CachePut(key = "#customer.id")
    Customer update(Customer customer);
    //allEntries = true清除所有缓存
    @CacheEvict(key = "#id", allEntries = true)
    void deleteStudentBySno(Integer id);


}
