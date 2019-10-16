package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsType {
    private int goodsTypeId;//商品类别id
    private String goodsTypeNumber;//类别代码
    private String goodsTypeName;//类别名称
    private String goodsTypeRemark;//备注
    private int goodsTypeDel;//删除标记
    private String goodsTypeRE;
    private List<Goods> goods;

    public GoodsType(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }
}
