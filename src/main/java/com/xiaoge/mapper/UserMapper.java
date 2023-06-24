package com.xiaoge.mapper;

import com.xiaoge.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {

    public List<User> queryUserList();
    public User getUserById(int id);
    // User getUserById(@Param("id") int id);

    // 这里是照着id搜索其他方法省略...
}
