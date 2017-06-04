package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import com.xiaoweiyunchuang.microcloud.domain.UserTest;

public interface UserTestService {

	public void saveUser(UserTest user);

	public boolean isUserExist(String name);

	public UserTest findUserById(long id);

	public List<UserTest> findAllUsers();

	public void updateUser(UserTest user);

	public void deleteUserById(long id);

	public void deleteAllUsers();

}
