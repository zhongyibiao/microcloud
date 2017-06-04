package com.xiaoweiyunchuang.microcloud.mapper;

import com.xiaoweiyunchuang.microcloud.domain.UserRole;

public interface UserRoleMapper {

    int deleteByPrimaryKey(String id);


    int insert(UserRole record);


    int insertSelective(UserRole record);


    UserRole selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(UserRole record);


    int updateByPrimaryKey(UserRole record);
}