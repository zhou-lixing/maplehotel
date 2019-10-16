package com.maplegroup.maplehotel.service;

import com.maplegroup.maplehotel.entity.Member;
import com.maplegroup.maplehotel.entity.ReserveInfo;

import java.util.List;
import java.util.Map;

public interface IRoomReserveService {

    //添加预定用户
    boolean addReserve(ReserveInfo reserveInfo, Member member);

    //删除预定用户
    boolean delReserve(String reserveInfoRoomNumber);

    //修改预定信息
    boolean updateReserve(String reserveInfoRoomNumber);

    //查找最大ID号所对应的预定单号
    String findMaxIdOfOrderNum();

    //根据房号查询预定信息
    ReserveInfo findReserveByRoomNumber(String reserveInfoRoomNumber);

    //根据预订人查询预定信息
    ReserveInfo findReserveByBooker(String reserveInfoBooker);

    //根据客房类型查询预定信息
    List<ReserveInfo> findReserveByType(String reserveInfoRoomType);

    //查询所有
    List<ReserveInfo> findAllReserve();

    List<ReserveInfo> find(Map<String,String> map);

    //通过房号取消预订信息
    boolean cancelReserveStatus(String reserveInfoRoomNumber);
}
