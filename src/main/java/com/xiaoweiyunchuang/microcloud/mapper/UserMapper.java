package com.xiaoweiyunchuang.microcloud.mapper;

import java.util.List;

import com.xiaoweiyunchuang.microcloud.domain.User;

public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(User user);

    int insertSelective(User user);

    List<User> searchSelective(User user);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User selectUserRolesAndPermissions(User user);
}