package com.maplegroup.maplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {
    private int roomTypeId;//客房类型id
    private String roomTypeNum;//客房编号
    private String roomTypeName;//类型名
    private int roomTypeNumber;//额定人数
    private String roomTypeRemark;//备注
    private int roomTypeDel;//删除标记
    private String roomTypeRE;
    private List<Room> rooms;

    public RoomType(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
