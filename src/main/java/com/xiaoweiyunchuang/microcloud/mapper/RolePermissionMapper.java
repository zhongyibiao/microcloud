package com.xiaoweiyunchuang.microcloud.mapper;

import com.xiaoweiyunchuang.microcloud.domain.RolePermission;

public interface RolePermissionMapper {

    int deleteByPrimaryKey(String id);


    int insert(RolePermission record);


    int insertSelective(RolePermission record);


    RolePermission selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(RolePermission record);


    int updateByPrimaryKey(RolePermission record);
}