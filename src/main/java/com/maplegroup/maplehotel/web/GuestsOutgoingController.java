package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.GuestsOutgoing;
import com.maplegroup.maplehotel.entity.ReservationGuest;
import com.maplegroup.maplehotel.service.impl.GuestsOutgoingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/outgoing")
public class GuestsOutgoingController {
    @Autowired
    private GuestsOutgoingService service;

    @ResponseBody
    @RequestMapping("/findOutgoing")
    public List<GuestsOutgoing> findOutgoing(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");//可以方便地修改日期格式
        String date = dateFormat.format( now );
        return service.findGuestsOutgoingByDate(date);
    }
}
