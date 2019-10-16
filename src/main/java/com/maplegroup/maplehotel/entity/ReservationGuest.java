package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationGuest {
    private String reserveInfoOrderNum;//预定单号
    private String reserveInfoRoomNumber;//客房编号
    private String reserveInfoRoomType;//客房类型
    private String reserveInfoBooker;//预订人
    private String reserveInfoVipNum;//会员编号
    private String reserveInfoArrivalTime;//抵店时间
    private String reserveInfoLeaveTime;//离店时间
    private String reserveInfoPhone;//预订电话

    private RoomType roomType;

    //主键构造方法
    public ReservationGuest(String reserveInfoOrderNum) {
        this.reserveInfoOrderNum = reserveInfoOrderNum;
    }
}
