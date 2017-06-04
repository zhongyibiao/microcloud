package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoweiyunchuang.microcloud.domain.Role;
import com.xiaoweiyunchuang.microcloud.mapper.RoleMapper;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	public List<Role> findRoleInfoByUserId(int userId) {
		return roleMapper.findRoleByUserId(userId);
	}
	
	
}
