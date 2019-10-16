package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int roomId;//客房id
    private String roomNumber;//客房编号
    private String roomType;//类型
    private String roomStatus;//状态
    private String roomFloor;//楼层
    private BigDecimal roomStandardPrice;//标准价格
    private BigDecimal roomDiscountPrice;//折后价
    private BigDecimal roomGoldVipPrice;//黄金会员价
    private BigDecimal roomPlatVipPrice;//铂金会员价
    private String roomRemark;//备注
    private int roomDel;//删除标记
    private String roomRE;
    private RoomType type;
    private Floor floor;
    public Room(int roomId) {
        this.roomId = roomId;
    }
}
