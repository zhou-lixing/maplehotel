package com.maplegroup.maplehotel.test;

import com.maplegroup.maplehotel.dao.IUserDao;
import com.maplegroup.maplehotel.entity.User;
import com.maplegroup.maplehotel.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UserServiceTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserDao userDao;
    @Test
    public void getUserPowerTest(){
        System.out.println(userService.getUserPower("admin"));
    }
    @Test
    public void addUserTest(){
        User Operator  = userDao.findUserByUsername("周利星");
        User user = new User();
        user.setUserUsername("admin");
        user.setUserPassword("12345");
        user.setUserPower(1);
        System.out.println(userService.addUser(Operator,user));
    }

    @Test
    public void loginTest(){
        User user = new User();
        user.setUserUsername("admin");
        user.setUserPassword("12345");
        System.out.println(userService.userLogin(user));
    }

    @Test
    public void updateUserTest(){
        User Operator  = userDao.findUserByUsername("周利星");
        User user = new User();
        user.setUserUsername("admin");
        user.setUserPassword("1234");
        System.out.println(userService.updateUser(Operator,user));
    }

    @Test
    public void deleteUserTest(){
        User Operator  = userDao.findUserByUsername("周利星");
        System.out.println(userService.deleteUser(Operator,"admin"));
    }

    @Test
    public void findAllUser(){
        userService.findAllUser().forEach(System.out::println);
    }

}