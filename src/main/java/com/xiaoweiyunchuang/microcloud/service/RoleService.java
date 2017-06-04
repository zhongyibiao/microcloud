package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import com.xiaoweiyunchuang.microcloud.domain.Role;

public interface RoleService {
	/**
	 * 获取角色模块
	 * 
	 * @param userId
	 * @return
	 */
	List<Role> findRoleInfoByUserId(int userId);
}
