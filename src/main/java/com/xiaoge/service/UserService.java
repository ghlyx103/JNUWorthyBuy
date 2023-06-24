package com.xiaoge.service;

import com.xiaoge.pojo.User;

import java.util.List;


public interface UserService {

    public List<User> queryUserList();
    User getUserById(int id);
    User saveUser(User user);
}

