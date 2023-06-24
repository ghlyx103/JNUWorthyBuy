package com.xiaoge.service.impl;

import com.xiaoge.mapper.GoodMapper;
import com.xiaoge.pojo.User;
import com.xiaoge.service.Good;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GoodServiceImpl {

    @Autowired
    private GoodMapper goodMapper;
    /*@Override*/
    public List<Good> queryGoodList() {
        log.info("Getting all goods");
        return goodMapper.queryGoodList();
    }
    public User getGoodById(int id) {
        log.info("Getting good by id: {}", id);
        return goodMapper.getGoodById(id);
    }
}
