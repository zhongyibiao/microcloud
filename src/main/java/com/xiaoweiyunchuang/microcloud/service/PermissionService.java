package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import com.xiaoweiyunchuang.microcloud.domain.Permission;


public interface PermissionService {
	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	List<Permission> findPermissionByUserId(int userId);
}
