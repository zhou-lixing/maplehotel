package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveInfo {
    private int reserveInfoId;//主键
    private String reserveInfoOrderNum;//预定单号
    private String reserveInfoRoomNumber;//客房编号  外键
    private String reserveInfoRoomType;//客房类型
    private BigDecimal reserveInfoStandardPrice;//标准价
    private BigDecimal reserveInfoDiscount;//折后价
    private BigDecimal reserveInfoDeposit;//押金
    private String reserveInfoBooker;//预订人
    private String reserveInfoIdType;//证件类别
    private String reserveInfoIdNumber;//证件号码
    private String reserveInfoPhone;//联系电话
    private String reserveInfoArrivalTime;//抵店时间
    private String reserveInfoLeaveTime;//离店时间
    private int reserveInfoHumanNum;//入住人数
    private String reserveInfoOperator;//操作员  外键
    private String reserveInfoVipNum;//会员编号
    private BigDecimal reserveInfoVipPrice;//会员价
    private String reserveInfoStatus;//预定状态
    private String reserveInfoRemark;//备注
    private int reserveInfoDel;//删除标记

    private RoomType roomType;
    private User user;


    public ReserveInfo(int reserveInfoId) {
        this.reserveInfoId = reserveInfoId;
    }
}
