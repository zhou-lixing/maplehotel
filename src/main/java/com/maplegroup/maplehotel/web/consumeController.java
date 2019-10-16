package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.dao.IGoodsTypeDao;
import com.maplegroup.maplehotel.entity.Consume;
import com.maplegroup.maplehotel.entity.Goods;
import com.maplegroup.maplehotel.entity.GoodsType;
import com.maplegroup.maplehotel.service.IConsumeService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consume")
public class consumeController {

    @Autowired
    private IConsumeService consumeService;

    @Autowired
    private HttpSession httpSession;

    //主页
    @RequestMapping("/consumeIndex")
    public ModelAndView test(){
        return  new ModelAndView("index");
    }

    //消费主页
    @RequestMapping("/consumeConsume")
    public ModelAndView testConsume(){
        return new ModelAndView("/consume/consume");
    }

    @ResponseBody
    @RequestMapping("/consumeFindAll")
    public List<Consume> consumeFindAll(){
        return consumeService.findConsumeAll();
    }

    //跳转商品查询页面
    @RequestMapping("/Commodity")
    public ModelAndView commodoty(String goodsType){
        httpSession.setAttribute("goodsType",goodsType);
        return new ModelAndView("/consume/find-commodity");
    }
    //商品查询   未实现
    @ResponseBody
    @RequestMapping("/consumeCommodity")
    public List<GoodsType> testCommodity(){
            String goodsType = (String)httpSession.getAttribute("goodsType");
            return consumeService.findGoods(goodsType);

    }

    //跳转消费查询页面
    @RequestMapping("/Consumption")
    public ModelAndView consumption(String roomNum){
        httpSession.setAttribute("roomNum",roomNum);
        return new ModelAndView("/consume/general-information");
    }

    //消费查询
    @ResponseBody
    @RequestMapping("/consumeConsumption")
    public List<Consume> testConsumption(){
        String roomNum = (String) httpSession.getAttribute("roomNum");
        return consumeService.findConsumeList(roomNum);
    }


    //修改消费信息
    @RequestMapping("/consume/Change")
    public ModelAndView testChange(){
        return new ModelAndView("/consume/modify-after");
    }

    //未实现
    @ResponseBody
    @RequestMapping("/consumeChonge")
    public boolean consumeChonge(Consume consume){
        return consumeService.changeConsume(consume);
    }
}
