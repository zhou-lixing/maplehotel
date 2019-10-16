package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IGoodsTypeDao;
import com.maplegroup.maplehotel.entity.GoodsType;
import com.maplegroup.maplehotel.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsTypeService implements IGoodsTypeService {

    @Autowired
    private IGoodsTypeDao goodsTypeDao;

    @Override
    public boolean addGoodsType(GoodsType goodsType) {
        if (goodsTypeDao.findGoodsTypeByName(goodsType.getGoodsTypeName())==null) {
            goodsTypeDao.addGoodsType(goodsType);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGoodsType(String goodsTypeName) {
        if(goodsTypeDao.deleteGoodsType(goodsTypeName) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByName(String goodsTypeName) {
        if (goodsTypeDao.updateByName(goodsTypeName)>0){
            return true;
        }
        return false;

    }

    @Override
    public GoodsType findGoodsTypeByName(String goodsTypeName) {
        GoodsType goodsType = goodsTypeDao.findGoodsTypeByName(goodsTypeName);
        return goodsTypeDao.findGoodsTypeByName(goodsTypeName);
    }

    @Override
    public List<GoodsType> findGoodsTypeAll() {
        List<GoodsType> goodsTypeList = goodsTypeDao.findGoodsTypeAll();
        return goodsTypeList;
    }
}
