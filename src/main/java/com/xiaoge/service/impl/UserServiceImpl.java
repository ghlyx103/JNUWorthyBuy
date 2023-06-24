package com.xiaoge.service.impl;

import com.xiaoge.repository.UserRepository;
import com.xiaoge.mapper.UserMapper;
import com.xiaoge.pojo.User;
import com.xiaoge.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> queryUserList() {
        log.info("Getting all users");
        return userMapper.queryUserList();
    }
    public User getUserById(int id) {
        log.info("Getting user by id: {}", id);
        return userMapper.getUserById(id);
    }
    public User saveUser(User user) {
        log.info("Saving user: {}", user);
        return userRepository.save(user);
    }
}
