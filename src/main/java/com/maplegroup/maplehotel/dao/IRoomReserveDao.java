package com.maplegroup.maplehotel.dao;

import com.maplegroup.maplehotel.entity.ReserveInfo;
import com.maplegroup.maplehotel.entity.User;

import java.util.List;
import java.util.Map;

public interface IRoomReserveDao {

     //添加预定用户
     void addReserve(ReserveInfo reserveInfo);
     //根据房号删除
     void delReserve(String reserveInfoRoomNumber);
     //根据房号修改
     void updateReserve(String reserveInfoRoomNumber);
     //查找最大ID号所对应的预定单号
     String findMaxIdOfOrderNum();

     //根据房号查询
     ReserveInfo findReserveByRoomNumber(String reserveInfoRoomNumber);
     //根据预订人查询
     ReserveInfo findReserveByBooker(String reserveInfoBooker);
     //根据客房类型查询
     List<ReserveInfo> findReserveByType(String reserveInfoRoomType);
     //查询所有
     List<ReserveInfo> findAllReserve();

     //查询
     List<ReserveInfo> find(Map<String,String> map);

     //通过房号取消预订信息
     void cancelReserveStatus(String reserveInfoRoomNumber);

}
