package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.Goods;

import java.util.List;

public interface IGoodsDao {

    //根据商品名查询商品
    Goods findGoodsByName(String goodsName);
    Goods findGoodsByNum(String goodsNum);
    List<Goods> findByType(String goodsType);
    //添加商品
    int addGoods(Goods goods);
    //删除商品
    int deleteGoods(String goodsNum);
    //查询所有商品
    List<Goods> findGoodsAll();
    //修改商品
    int updateByNum(String goodsNum);
    String findMaxNum();
}
