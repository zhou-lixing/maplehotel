package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.ReservationGuest;
import com.maplegroup.maplehotel.service.IReservationGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired//注入对象
    private IReservationGuestService reservationGuestService;

    @RequestMapping("reserve")
    public ModelAndView reserve(){
        return new ModelAndView("ReportManage/ReservationGuest");
    }
    @RequestMapping("guestsStaying")
    public ModelAndView reserveIndex(){
        return new ModelAndView("ReportManage/GuestsStaying");
    }
    @RequestMapping("guestsOutgoing")
    public ModelAndView outGoing(){
        return new ModelAndView("ReportManage/GuestsOutgoing");
    }
    @RequestMapping("financeAccounting")
    public ModelAndView finance(){
        return new ModelAndView("ReportManage/FinanceAccounting");
    }

    @ResponseBody
    @RequestMapping("/findAllReserve")
    public List<ReservationGuest> findAll(){
        return reservationGuestService.findAll();
    }

    @ResponseBody
    @RequestMapping("/findReserve")
    public List<ReservationGuest> findReserve(@RequestParam Map<String,Object> map){
        String startDate = map.get("startDate").toString();
        startDate = startDate.replace("-","");
        String endDate = (String)map.get("endDate");
        endDate = endDate.replace("-","");
        String roomNum = map.get("roomNumber").toString();
        if(roomNum.equals("")){
            //根据日期查
            return reservationGuestService.findReservationGuestByDate(startDate,endDate);
        }else{
            //根据编号查
            return reservationGuestService.findReservationGuestByRoomNum(roomNum);
        }

    }


}
