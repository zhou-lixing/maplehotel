package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.Consume;
import com.maplegroup.maplehotel.entity.Goods;
import com.maplegroup.maplehotel.entity.GoodsType;
import com.maplegroup.maplehotel.entity.RoomType;

import java.math.BigDecimal;
import java.util.List;

public interface IConsumeService {

    //查询商品信息
    public List<GoodsType> findGoods(String goodsTypeName);

    //查询所有消费信息
    public List<Consume> findConsumeAll();

    //消费入账
    public boolean moneyInto(Consume consume);

    //查询消费信息
    public List<Consume> findConsumeList(String roomNum);

    //修改消费信息
    public boolean changeConsume(Consume consume);

    //打印消费单
    public List<Consume> printingConsumeList(String roomNum);

    //获取金额方法
    public BigDecimal consumeMoney(Consume consume);

    //获取折后金额
    public BigDecimal consumeDisPrice(Consume consume);

    //根据房间号获取总消费金额方法
    public BigDecimal consumeTotal(String roomNum);

}
