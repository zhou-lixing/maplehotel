package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int goodsId;//商品id
    private int goodsCount;//商品数量
    private String goodsNum;//商品代码
    private String goodsName;//商品名
    private String goodsType;//商品类别
    private BigDecimal goodsPrice;//价格
    private String goodsUnit;//单位
    private String goodsRemark;//备注
    private int goodsDel;//删除标记
    private String goodsRE;
    private GoodsType type;
    public Goods(int goodsId) {
        this.goodsId = goodsId;
    }
}
