package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;//主键
    private String userIdentifier;//用户编号
    private String userUsername;//用户名
    private String userPassword;//密码
    private int userPower;//权限
    private String userRemark;//备注
    private int userDel;//删除标记
    private String userRE;//预留
    private List<Journal> journals;//用户产生的日志


    public User(int userId) {
        this.userId = userId;
    }
}
