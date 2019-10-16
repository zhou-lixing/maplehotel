package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.Room;
import com.maplegroup.maplehotel.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @RequestMapping("/roomView")
    public ModelAndView room() {
        return new ModelAndView("room/room");
    }

    @ResponseBody
    @RequestMapping("/findRoomAll")
    public List<Room> findRoomAll() {
        return roomService.findRoomAll();
    }

    @ResponseBody
    @RequestMapping("/addRoomIndex")
    public ModelAndView addRoomIndex() {
        return new ModelAndView("room/roomAdd");
    }

    @ResponseBody
    @RequestMapping("/deleteRoom/{roomNumber}")
    public boolean deleteRoom(@PathVariable("roomNumber") String roomNumber) {
        return roomService.deleteRoom(roomNumber);
    }

}
