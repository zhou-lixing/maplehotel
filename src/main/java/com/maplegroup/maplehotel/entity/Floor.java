package com.maplegroup.maplehotel.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Floor {
    private int floorId;//楼层id
    private String floorNum;//楼层编号
    private String floorName;//楼层名
    private String floorRemark;//备注
    private int floorDel;//删除标记
    private String floorRE;
    private List<Room> rooms;

    public Floor(int floorId) {
        this.floorId = floorId;
    }

}
