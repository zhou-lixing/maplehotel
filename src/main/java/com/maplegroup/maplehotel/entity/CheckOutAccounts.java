package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckOutAccounts {
    private int checkOutId;//主键
    private String checkOutCheckInNum;//入住单号  外键
    private String checkOutHomeNum;//客房编号
    private BigDecimal checkOutHomePrice;//房价
    private BigDecimal checkOutDeposit;//押金
    private int checkOutDayNum;//住宿天数
    private BigDecimal checkOutHotelPrice;//住宿费
    private BigDecimal checkOutInStoreConsume;//店内消费
    private BigDecimal checkOutMealPrice;//餐费
    private BigDecimal checkOutPhonePrice;//电话费
    private BigDecimal checkOutShouldReceive;//实际应收
    private BigDecimal checkOutShouldRefund;//应退押金
    private String checkOutPayMethod;//付款方式
    private BigDecimal checkOutReceive;//实收
    private BigDecimal checkOutGiveChange;//找零
    private String checkOutOperator;//操作员  外键
    private String checkOutRemark;//备注
    private int checkOutDEl;//删除标记
    private String checkOutTime;//结账时间

    private User user;
    private List<Consume> consumes;

    public CheckOutAccounts(int checkOutId) {
        this.checkOutId = checkOutId;
    }
}
