package com.cb.service;

import com.cb.dao.UserMapper;
import com.cb.pojo.User;

public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
