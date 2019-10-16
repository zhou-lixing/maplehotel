package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int memberId;//会员id
    private String memberIdentifier;//会员编号
    private String memberName;//姓名
    private String memberSex;//性别
    private String memberPassword;//密码
    private String memberPhoneNumber;//电话
    private String memberAddress;//地址
    private String memberEmail;//email
    private String memberIntegral;//积分
    private String memberLevel;//级别
    private String memberLastCheckIn;//最后一次入住时间
    private String memberFinalBooking;//最后一次预定时间
    private String memberRemark;//备注
    private int memberDel;//删除标记
    private String memberRE;
    private List<ReserveInfo> reserveInfos;
    private List<CheckInInfo> checkInInfos;

    public Member(int memberId) {
        this.memberId = memberId;
    }
}
