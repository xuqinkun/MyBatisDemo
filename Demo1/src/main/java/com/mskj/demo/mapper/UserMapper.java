package com.mskj.demo.mapper;

import com.mskj.demo.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 面向接口编程的mybatis有两个一致：
     * 1. 映射文件中namespace与Mapper接口的全类名一致
     * 2. SQL语句的id与方法名保持一致
     * @param id
     * @return
     */
    User getUser(int id);

    List<User> getAllUsers();

    int insertUser(User u);
}
