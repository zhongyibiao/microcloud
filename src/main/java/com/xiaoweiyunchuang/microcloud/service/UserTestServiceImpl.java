package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoweiyunchuang.microcloud.domain.UserTest;
import com.xiaoweiyunchuang.microcloud.mapper.UserTestMapper;

@Service
public class UserTestServiceImpl implements UserTestService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserTestMapper mapper;

	@Transactional
	public void saveUser(UserTest user) {
		mapper.saveUser(user);
	}

	public boolean isUserExist(String name) {
		List<UserTest> users = mapper.findUserByName(name);

		for (UserTest user : users) {
			if (user.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;

	}

	public UserTest findUserById(long id) {
		UserTest user = mapper.findUserById(id);
		return user;
	}

	public List<UserTest> findAllUsers() {
		List<UserTest> users = mapper.findAllUsers();
		return users;
	}

	@Transactional
	public void updateUser(UserTest user) {
		mapper.updateUser(user);
	}

	@Transactional
	public void deleteUserById(long id) {
		mapper.deleteUserById(id);
	}

	@Transactional
	public void deleteAllUsers() {
		mapper.deleteAllUsers();
	}

}
