package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.Goods;

import java.util.List;

public interface IGoodsService {
    //添加商品
    public boolean addGoods(Goods goods);

    //删除商品
    public boolean deleteGoods(String goodsNum);

    //修改商品
    public boolean updateGoodsByNum(String goodsNum);

    //查询商品
    Goods findGoodsByName(String goodsName);
    Goods findGoodsByNum(String goodsNum);
    List<Goods> findByType(String goodsType);
    List<Goods> findGoodsAll();
}
