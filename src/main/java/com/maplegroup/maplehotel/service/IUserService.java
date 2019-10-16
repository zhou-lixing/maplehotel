package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.User;

import java.util.List;

public interface IUserService {
    //获取用户信息
    User findUserByUsername(String username);
    User findUserById(String id);
    //获取用户权限
    int getUserPower(String username);
    //添加用户
    boolean addUser(User Operator,User user);
    //登录
    boolean userLogin(User user);
    //修改用户
    boolean updateUser(User Operator,User user);
    //删除用户
    boolean deleteUser(User Operator,String username);
    //获取全部用户
    List<User> findAllUser();

}
