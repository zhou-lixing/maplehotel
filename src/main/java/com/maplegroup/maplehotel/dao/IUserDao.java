package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.Journal;
import com.maplegroup.maplehotel.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface IUserDao {
    //查询当前编号最大值
    String getMaxId();
    //根据用户名查询用户信息
    User findUserByUsername(String username);
    //根据用户id查询用户信息
    User findUserById(String id);
    //获取全部用户信息
    List<User> findAllUser();
    //增加用户
    int addUser(User user);
    //根据编号删除用户
    int deleteUser(String userIdentifier);
    //根据用户名修改用户
    int updateUser(User user);
}