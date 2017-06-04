package com.xiaoweiyunchuang.microcloud.service;

import java.util.List;

import com.xiaoweiyunchuang.microcloud.domain.User;

public interface UserService {

    public User findUser(String id);

    public User findUserByAccount(String account);


    public List<User> findUserList(User user);


    public void createUser(User user);


    public void updateUser(User user);


    public void deleteUser(String id);

    public User findUserRolesAndPermissions(User user);

}
