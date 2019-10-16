package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.IGoodsDao;
import com.maplegroup.maplehotel.entity.Goods;
import com.maplegroup.maplehotel.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GoodsService implements IGoodsService {

    @Autowired
    private IGoodsDao goodsDao;

    @Override
    public boolean addGoods(Goods goods) {
        String str = goodsDao.findMaxNum();
        String num = str.replaceAll("[a-zA-Z]","");
        String goodsNum = "GT0" + (Integer.parseInt(num)+1)+"";
        goods.setGoodsNum(goodsNum);
        if (goodsDao.addGoods(goods)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGoods(String goodsNum) {
        if (goodsDao.deleteGoods(goodsNum)>0){
            return true;
        }
        return false;

    }

    @Override
    public boolean updateGoodsByNum(String goodsNum) {
        goodsDao.updateByNum(goodsNum);
        return true;
    }

    @Override
    public Goods findGoodsByName(String goodsName) {
        Goods goods = goodsDao.findGoodsByName(goodsName);
        return goods;
    }

    @Override
    public Goods findGoodsByNum(String goodsNum) {
        Goods goods = goodsDao.findGoodsByNum(goodsNum);
        return goods;
    }

    @Override
    public List<Goods> findByType(String goodsType) {
        List<Goods> goodsList = goodsDao.findByType(goodsType);
        return goodsList;
    }


    @Override
    public List<Goods> findGoodsAll() {
        List<Goods> goodsList = goodsDao.findGoodsAll();
        return goodsList;
    }
}
