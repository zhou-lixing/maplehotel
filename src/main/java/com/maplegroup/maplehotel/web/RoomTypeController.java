package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.RoomType;
import com.maplegroup.maplehotel.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/roomType")
public class RoomTypeController {

    @Autowired
    private IRoomTypeService roomTypeService;

    @RequestMapping("/roomTypeView")
    public ModelAndView roomType() {
        return new ModelAndView("roomType/roomType");
    }

    @ResponseBody
    @RequestMapping("/findRoomTypeAll")
    public List<RoomType> findRoomTypeAll() {
        return roomTypeService.findAll();
    }

    @ResponseBody
    @RequestMapping("/addRoomTypeIndex")
    public ModelAndView addRoomTypeIndex() {
        return new ModelAndView("roomType/roomTypeAdd");
    }

    @ResponseBody
    @RequestMapping("/deleteRoomType/{roomTypeNum}")
    public boolean deleteRoomType(@PathVariable("roomTypeNum") String roomTypeNum) {
        return roomTypeService.deleteRoomType(roomTypeNum);
    }

}
