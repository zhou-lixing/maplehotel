package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consume {
    private int consumeId;//主键
    private String consumeHomeNum; //客房编号
    private int consumeCount;  //数量
    private BigDecimal consumePrice;//单价
    private BigDecimal consumeMoney;//消费金额
    private double consumeDiscountRate;//折扣率
    private BigDecimal consumeDiscountPrice;//折后金额
    private BigDecimal consumeTotal;//合计
    private String consumeTime;//消费时间
    private String consumeRemark;//备注
    private int consumeDel;//删除标记
    private  String consumeCheckInNum;//入住单号
    private String consumeOperator;//操作员
    private String consumeGoodsName;//商品名，商品外键
   // private String checkOutInStoreConsume;//退房结账消费外键
    private String consumeRE;//预留列
    private Goods goods;//商品
    private GoodsType goodsTypes;//商品类型



    public Consume(int consumeId){
        this.consumeId = consumeId;
    }


}
