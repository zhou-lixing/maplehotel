package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeRoom {
    private int changeHomeId;//主键
    private String changeHomeCheckInNum;//入住单号 外键
    private String changeHomeBeforeHomeNum;//原客房编号
    private String changeHomeAfterHomeNum;//换后客房编号
    private String changeHomeRoomType;//客房类型
    private BigDecimal changeHomeStandardPrice;//标准价
    private BigDecimal changeHomeDiscountPrice;//折后价
    private BigDecimal changeHomeDeposit;//押金
    private String changeHomeHuman;//入住人
    private String changeHomeCertificateType;//证件类型
    private String changeHomeCertificateNum;//证件号码
    private String changeHomePhone;//联系电话
    private String changeHomeArrivalTime;//抵店时间
    private String changeHomeLeaveTime;//离店时间
    private int changeHomeHumanNum;//入住人数
    private String changeHomeOperator;//操作员 外键
    private String changeHomeVipNum;//会员编号  外键
    private BigDecimal changeHomeVipPrice;//会员价
    private String changeHomeBreakfast;//提供早餐
    private String changeHomeWakeUp;//定时叫醒
    private String changeHomeRemark;//备注
    private int changeHomeDel;//删除标记

    private RoomType roomType;
    private User user;

    public ChangeRoom(int changeHomeId) {
        this.changeHomeId = changeHomeId;
    }
}
