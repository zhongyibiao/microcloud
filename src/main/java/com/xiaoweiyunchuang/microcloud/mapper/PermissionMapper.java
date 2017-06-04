package com.xiaoweiyunchuang.microcloud.mapper;

import java.util.List;

import com.xiaoweiyunchuang.microcloud.domain.Permission;

public interface PermissionMapper {

	int deleteByPrimaryKey(String id);

	int insert(Permission record);

	int insertSelective(Permission record);

	Permission selectByPrimaryKey(String id);

	List<Permission> findPermissionByUserId(int userId);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
	
}