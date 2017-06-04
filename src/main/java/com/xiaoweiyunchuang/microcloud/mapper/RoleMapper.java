package com.xiaoweiyunchuang.microcloud.mapper;

import java.util.List;

import com.xiaoweiyunchuang.microcloud.domain.Role;

public interface RoleMapper {

    int deleteByPrimaryKey(String id);


    int insert(Role record);


    int insertSelective(Role record);


    Role selectByPrimaryKey(String id);
    
    List<Role> findRoleByUserId(int userId);


    int updateByPrimaryKeySelective(Role record);


    int updateByPrimaryKey(Role record);
}