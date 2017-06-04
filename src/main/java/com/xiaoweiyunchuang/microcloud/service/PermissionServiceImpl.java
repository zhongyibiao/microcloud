package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoweiyunchuang.microcloud.domain.Permission;
import com.xiaoweiyunchuang.microcloud.mapper.PermissionMapper;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	private PermissionMapper permissionMapper;

	/**
	 * 获取角色模块
	 * 
	 * @param userId
	 * @return
	 */
	public List<Permission> findPermissionByUserId(int userId) {
		return permissionMapper.findPermissionByUserId(userId);
	}
}
