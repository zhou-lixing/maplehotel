package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.Floor;
import com.maplegroup.maplehotel.service.IFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/floor")
public class FloorController {

    @Autowired
    private IFloorService floorService;

    @ResponseBody
    @RequestMapping("/floorView")
    public ModelAndView Floor() {
        return new ModelAndView("floor/floor");
    }

    @ResponseBody
    @RequestMapping("/findFloorAll")
    public List<Floor> findFloorAll() {
        return floorService.findFloorAll();
    }



    @RequestMapping("/addFloorIndex")
    public ModelAndView addFloorIndex(){
        return new ModelAndView("floor/floorAdd");
    }


    @ResponseBody
    @RequestMapping("/addFloor")
    public boolean addFloor(@RequestParam Map<String,Object> map) {

        Floor floor = new Floor();

        floor.setFloorNum((String)map.get("floorNum"));
        floor.setFloorName((String)map.get("floorName"));
        return floorService.addFloor(floor);
    }

    @ResponseBody
    @RequestMapping("/deleteFloor/{floorName}")
    public boolean deleteFloor(@PathVariable("floorName") String floorName) {
        return floorService.deleteFloor(floorName);
    }

}
