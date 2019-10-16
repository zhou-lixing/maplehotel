package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.GoodsType;

import java.util.List;


public interface IGoodsTypeService {

    //添加商品类别
    public boolean addGoodsType(GoodsType goodsType);

    //删除商品类别
    public boolean deleteGoodsType(String goodsTypeName);

    //修改商品类别
    public boolean updateByName(String goodsTypeName);

    //查询商品类别
    GoodsType findGoodsTypeByName(String goodsTypeName);
    List<GoodsType> findGoodsTypeAll();
}
