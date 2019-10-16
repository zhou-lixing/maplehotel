package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.Floor;
import com.maplegroup.maplehotel.entity.Goods;
import com.maplegroup.maplehotel.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/goodsView")
    public ModelAndView goods() {
        return new ModelAndView("goods/goods");
    }

    @ResponseBody
    @RequestMapping("/findGoodsAll")
    public List<Goods> findGoodsAll() {
        return goodsService.findGoodsAll();
    }

    @ResponseBody
    @RequestMapping("/addGoodsIndex")
    public ModelAndView addGoodsIndex() {
        return new ModelAndView("goods/goodsAdd");
    }

    @ResponseBody
    @RequestMapping("/addGoods")
    public boolean addGoods(@RequestParam Map<String,Object> map) {

        Goods goods = new Goods();
        System.out.println(map.get("goodsName").toString());
        System.out.println(map.get("goodsCount").toString());
        System.out.println(map.get("goodsType").toString());
        System.out.println(map.get("goodsPrice").toString());
        System.out.println(map.get("goodsUnit").toString());
        goods.setGoodsName((String)map.get("goodsName"));
        goods.setGoodsCount(Integer.parseInt(map.get("goodsCount").toString()));
        goods.setGoodsType((String)map.get("goodsType"));
        goods.setGoodsPrice(new BigDecimal(Integer.parseInt(map.get("goodsPrice").toString())));
        goods.setGoodsUnit((String)map.get("goodsUnit"));

        return goodsService.addGoods(goods);
    }


    @ResponseBody
    @RequestMapping("/deleteGoods/{goodsName}")
    public boolean deleteGoods(@PathVariable("goodsName") String goodsName) {
        return goodsService.deleteGoods(goodsName);
    }

}
