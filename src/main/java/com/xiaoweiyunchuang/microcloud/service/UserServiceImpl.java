package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoweiyunchuang.microcloud.domain.User;
import com.xiaoweiyunchuang.microcloud.mapper.UserMapper;

/**
 * Created by Administrator on 2016/11/16.
 */
@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(String id) {
		User user = new User();
		user.setId(id);
		return getUser(user);
	}

	public User getUser(User user) {
		List<User> result = findUserList(user);
		if (!result.isEmpty() && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public User findUserByAccount(String account) {
		User user = new User();
		user.setAccount(account);
		return getUser(user);
	}

	@Override
	public List<User> findUserList(User user) {
		return userMapper.searchSelective(user);
	}

	@Override
	@Transactional
	public void createUser(User user) {
		userMapper.insert(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User findUserRolesAndPermissions(User user) {
		return userMapper.selectUserRolesAndPermissions(user);
	}

}
