package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.GoodsType;

import java.util.List;

public interface IGoodsTypeDao {
    //根据商品类别名查询
    GoodsType findGoodsTypeByName(String goodsTypeName);
    //根据商品类别查询商品
    List<GoodsType> findGoodsByGoodsType(String goodsType);
    //添加商品类别
    void addGoodsType(GoodsType goodsType);
    //删除商品类别
    int deleteGoodsType(String goodsTypeName);
    //查询所有商品类别
    List<GoodsType> findGoodsTypeAll();
    //修改商品类别
    int updateByName(String goodsTypeName);
}
