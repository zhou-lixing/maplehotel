package com.maplegroup.maplehotel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestsOutgoing {
    private String checkInInfoCheckInNum;//入住单号
    private String checkInInfoHomeNum;//客房编号
    private String checkInInfoRoomType;//客房类型
    private String checkInInfoHuman;//入住人
    private int checkInInfoVipNum;//会员编号
    private String checkInInfoArrivalTime;//到店时间
    private String checkInInfoLeaveTime;//离开时间
    private String checkInInfoPhone;//联系电话

    private RoomType roomType;

    //主键构造方法
    public GuestsOutgoing
    (String checkInInfoHomeNum){
        this.checkInInfoHomeNum = checkInInfoHomeNum;
    }
}
