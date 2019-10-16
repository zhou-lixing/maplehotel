package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.ReservationGuest;
import com.maplegroup.maplehotel.service.IGuestsStayingService;
import com.maplegroup.maplehotel.service.impl.GuestsStayingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.maplegroup.maplehotel.entity.GuestsStaying;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/staying")
public class GusetsStayingController {

    @Autowired
    private IGuestsStayingService stayingService;

    @ResponseBody
    @RequestMapping("/findAllStaying")
    public List<GuestsStaying> findAll(){
        return stayingService.findAll();
    }

    @ResponseBody
    @RequestMapping("/findStaying")
    public List<GuestsStaying> findStaying(@RequestParam Map<String,Object> map){

        String startDate = map.get("startDate").toString();
        startDate = startDate.replace("-","");
        String endDate = (String)map.get("endDate");
        endDate = endDate.replace("-","");
        String roomNum = map.get("roomNumber").toString();

        if(roomNum.equals("")){
            //根据日期查
            return stayingService.findGuestsStayingByDate(startDate,endDate);
        }else{
            //根据编号查
            return stayingService.findGuestsStayingByHomeNum(roomNum);
        }

    }

}
