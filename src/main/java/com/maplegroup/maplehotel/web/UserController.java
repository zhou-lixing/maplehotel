package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.User;
import com.maplegroup.maplehotel.service.IUserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private HttpSession httpSession;
    //登录模块
    @RequestMapping("/login")
    public ModelAndView login(String username, String password){
        User user = new User();
        user.setUserUsername(username);
        user.setUserPassword(password);
        if(userService.userLogin(user)){
            //登录成功
            httpSession.setAttribute("username",username);
            // 进入首页
            return new ModelAndView("index");
        }else{
            //登陆失败
            return new ModelAndView(new RedirectView("../login.html?status=1"));
        }
    }
    //注销登录
    @RequestMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "redirect:/login.html";
    }

    //用户信息模块
    @RequestMapping("/userInfo")
    public ModelAndView userInfo(){
        return new ModelAndView("user/userInfo");
    }

    //响应当前用户信息
    @ResponseBody
    @RequestMapping("/userInfoContent")
    public Map<String,String> getUserInfo(){
        Map<String,String> map = new HashMap<>();
        User user = userService.findUserByUsername((String)httpSession.getAttribute("username"));
        map.put("userId",user.getUserIdentifier());
        map.put("username",user.getUserUsername());
        String powername = "";
        switch (userService.getUserPower(user.getUserUsername())){
            case 1: powername="管理员";
                break;
            case 2: powername="经理";
                break;
            case 3:powername="前台";
                break;
        }
        map.put("power",powername);
        map.put("powerId",user.getUserPower()+"");
        return map;
    }
    //跳转修改用户信息
    @RequestMapping("/userInfoChange")
    public ModelAndView userInfoChange(){
        return new ModelAndView("user/userInfoChange");
    }
    //提交修改
    @ResponseBody
    @RequestMapping("/userInfoChangeSub")
    public boolean userInfoChangeSub(@RequestParam Map<String,Object> map){
        User user = new User();
        user.setUserUsername((String)httpSession.getAttribute("username"));
        user.setUserPassword((String)map.get("oldPwd"));
        //判断原密码是否正确
        if(userService.userLogin(user)){
            user.setUserPassword((String)map.get("newPwd"));
            user.setUserPower(Integer.parseInt((String) map.get("powerSelect")));

            if(userService.updateUser(userService.findUserByUsername((String)httpSession.getAttribute("username")),user)){
                return true;
            }
        }
        return false;
    }

    //管理员或经理查看和修改所有人的信息
    @RequestMapping("/userSettings")
    public ModelAndView userSettings(){
        return new ModelAndView("user/userSettings");
    }

    //返回全部用户的信息
    @ResponseBody
    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.findAllUser();
    }

    //删除用户
    @ResponseBody
    @RequestMapping("/delUser/{username}")
    public boolean delUser(@PathVariable("username") String username){
        return userService.deleteUser(userService.findUserByUsername((String)httpSession.getAttribute("username")),username);
    }

    //添加新用户跳转
    @RequestMapping("/addUser")
    public ModelAndView addUser(){
        return new ModelAndView("user/userAdd");
    }

    //添加用户
    @ResponseBody
    @RequestMapping("/addUserSub")
    public boolean addUserSub(@RequestParam Map<String,Object> map){
        User user = new User();
        User op = userService.findUserByUsername((String)httpSession.getAttribute("username"));
        user.setUserUsername((String)map.get("username"));
        user.setUserPassword((String)map.get("password"));
        user.setUserPower(Integer.parseInt((String)map.get("userPower")));
        //判断原密码是否正确
        if(userService.addUser(op,user)){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping("/findUser")
    public User findUser(@RequestParam Map<String,Object> map){
        String content = (String)map.get("content");
        if(isNumericZidai(content)){
            return userService.findUserById(content);
        }else{
            return userService.findUserByUsername(content);
        }
    }

    //修改用户
    @ResponseBody
    @RequestMapping("/changeUser/{userId}")
    public ModelAndView changeUser(@PathVariable("userId") String userId){
        httpSession.setAttribute("changeUserId",userId);
        return new ModelAndView("user/userSetChange");
    }

    public static boolean isNumericZidai(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //响应某个用户信息
    @ResponseBody
    @RequestMapping("/changeUserContent")
    public User changeUser(){
        String userId =(String) httpSession.getAttribute("changeUserId");
        return userService.findUserById(userId);
    }

    //提交修改
    @ResponseBody
    @RequestMapping("/userInfoChangeSubAdmin")
    public boolean userInfoChangeSubAdmin(@RequestParam Map<String,Object> map){
        String userId =(String) httpSession.getAttribute("changeUserId");
        User user =  userService.findUserById(userId);
        //判断密码是否为空,不输入密码默认修改权限，不修改密码
        if(!(map.get("newPwd")).equals("")){
            user.setUserPassword((String)map.get("newPwd"));
        }
        user.setUserPower(Integer.parseInt((String) map.get("powerSelect")));
        if(userService.updateUser(userService.findUserByUsername((String)httpSession.getAttribute("username")),user)){
            return true;
        }
        return false;
    }
}