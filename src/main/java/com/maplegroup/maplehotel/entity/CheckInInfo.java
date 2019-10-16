package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckInInfo {
    private int checkInInfoId;//主键
    private String checkInInfoCheckInNum;//入住单单号
    private String checkInInfoHomeNum;//客房编号
    private String checkInInfoRoomType;//客房类型
    private BigDecimal checkInInfoStandardPrice;//标准价
    private BigDecimal checkInInfoDiscountPrice;//折后价
    private BigDecimal checkInInfoDeposit;//押金
    private String checkInInfoHuman;//入住人
    private String checkInInfoCertificateType;//证件类型
    private String checkInInfoCertificateNum;//证件号码
    private String checkInInfoPhone;//联系电话
    private String checkInInfoArrivalTime;//抵店时间
    private String checkInInfoLeaveTime;//离店时间
    private int checkInInfoHumanNum;//入住人数
    private String checkInInfoOperator;//操作员   外键
    private String checkInInfoVipNum;//会员编号

    private BigDecimal checkInInfoVipPrice;//会员价
    private String checkInInfoBreakfast;//提供早餐
    private String checkInInfoWakeUp;//定时叫醒
    private String checkInInfoRemark;//备注
    private int checkInInfoDel;//删除标记

    private RoomType roomType;
    private User user;


    public CheckInInfo(int checkInInfoId) {
        this.checkInInfoId = checkInInfoId;
    }
}
