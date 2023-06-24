package com.xiaoge.mapper;

import com.xiaoge.pojo.User;
import com.xiaoge.service.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {
    public List<Good> queryGoodList();
    User getGoodById(int id);
}
