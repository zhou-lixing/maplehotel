package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanceAccount {
    private String checkOutCheckInNum;//入住单号
    private String checkOutHomeNum;//客房编号
    private String checkOutReceive;//付款金额
    private String checkOutPayMethod;//进账方式
    private String checkOutTime;//进账时间

    private Room room;//客房编号对应的客房信息
    private RoomType roomType;//客房信息对应的客房类型
    private CheckInInfo checkInInfo;//入住信息表

    public FinanceAccount(String checkOutCheckInNum) {
        this.checkOutCheckInNum = checkOutCheckInNum;
    }
}
