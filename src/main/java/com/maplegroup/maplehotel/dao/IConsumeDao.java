package com.maplegroup.maplehotel.dao;


import com.maplegroup.maplehotel.entity.Consume;

import java.math.BigDecimal;
import java.util.List;

public interface IConsumeDao {

    //查询商品信息
    public List<Consume> findGoods(String goodsType);

    //查询所有消费信息
    public List<Consume> findConsumeAll();

    //消费入账
   public int moneyInto(Consume consume);

    //查询消费信息
    public List<Consume> findConsumeList(String roomNum);

    //修改消费信息
    public   int changeConsume(Consume consume);

    //打印消费单
    public List<Consume> printingConsumeList(String rooNum);


}
