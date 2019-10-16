package com.maplegroup.maplehotel.service.impl;

import com.maplegroup.maplehotel.dao.ICheckInRegistDao;
import com.maplegroup.maplehotel.dao.IConsumeDao;
import com.maplegroup.maplehotel.dao.IGoodsDao;
import com.maplegroup.maplehotel.dao.IGoodsTypeDao;
import com.maplegroup.maplehotel.entity.Consume;
import com.maplegroup.maplehotel.entity.GoodsType;
import com.maplegroup.maplehotel.service.IConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class consumeService implements IConsumeService {

    @Autowired
    private IConsumeDao consumeDao;
    @Autowired
    private IGoodsTypeDao goodsTypeDao;
    @Autowired
    private IGoodsDao goodsDao;
    @Autowired
    private ICheckInRegistDao checkInRegistDao;

    //通过商品类型查询商品信息

    @Override
    public List<GoodsType> findGoods(String goodsTypeName) {

        return goodsTypeDao.findGoodsByGoodsType(goodsTypeName);

    }

    //查询所有消费信息
    @Override
    public List<Consume> findConsumeAll() {
        return consumeDao.findConsumeAll();
    }

    //消费入账
    @Override
    public boolean moneyInto(Consume consume) {

       consumeDao.moneyInto(consume);
        return false;
    }

    //查询消费信息
    @Override
    public List<Consume> findConsumeList(String roomNum) {

        return consumeDao.findConsumeList(roomNum);
    }

    //修改消费信息
    @Override
    public boolean changeConsume(Consume consume) {

        consumeDao.changeConsume(consume);
        return false;
    }

    //打印消费单
    @Override
    public List<Consume> printingConsumeList(String roomNum) {

        return consumeDao.findConsumeList(roomNum);
    }

    //获取金额方法
    @Override
    public BigDecimal consumeMoney(Consume consume) {

        return goodsDao.findGoodsByName("可乐").getGoodsPrice().
                multiply(new BigDecimal(consume.getConsumeCount()));

    }
    //获取折后金额
    @Override
    public BigDecimal consumeDisPrice(Consume consume) {

        return consume.getConsumeMoney().multiply(new BigDecimal(consume.getConsumeDiscountRate()));

    }

    //根据房间号获取总消费金额方法
    @Override
    public BigDecimal consumeTotal(String roomNum) {
        BigDecimal sum=new BigDecimal(0);
        for (Consume consume : consumeDao.findConsumeList(roomNum)) {
            sum=sum.add(consume.getConsumeDiscountPrice());
        }
        return sum;
    }



}
