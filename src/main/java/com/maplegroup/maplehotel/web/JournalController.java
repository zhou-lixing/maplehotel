package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.Journal;
import com.maplegroup.maplehotel.service.impl.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;

    //跳转到日志页面
    @RequestMapping("/journal")
    public ModelAndView journal(){
        return new ModelAndView("journal/journal");
    }
    //查询全部日志
    @ResponseBody
    @RequestMapping("/findAllJournal")
    public List<Journal> findAllJournal(){
        return journalService.findAllJournal();
    }

    //根据条件搜索日志
    @ResponseBody
    @RequestMapping("/findJournal")
    public List<Journal> findJournalDo(@RequestParam Map<String,Object> map){
        String username = (String)map.get("username");
        String startDate = (String)map.get("startDate");
        String endDate = (String)map.get("endDate");
        startDate=startDate.replace("-","");
        endDate=endDate.replace("-","");
        if(!username.equals("")){
            return journalService.findJournalByUsername(username);
        }else{
            return journalService.findJournalByDate(startDate,endDate);
        }
    }
}
