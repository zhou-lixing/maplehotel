package com.maplegroup.maplehotel.web;

import com.maplegroup.maplehotel.entity.Goods;
import com.maplegroup.maplehotel.entity.GoodsType;
import com.maplegroup.maplehotel.service.IGoodsTypeService;
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
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    private IGoodsTypeService goodsTypeService;

    @RequestMapping("/goodsTypeView")
    public ModelAndView goodsType() {
        return new ModelAndView("goodsType/goodsType");
    }

    @ResponseBody
    @RequestMapping("/findGoodsTypeAll")
    public List<GoodsType> findGoodsTypeAll() {
        return goodsTypeService.findGoodsTypeAll();
    }

    @ResponseBody
    @RequestMapping("/addGoodsTypeIndex")
    public ModelAndView addGoodsTypeIndex() {
        return new ModelAndView("goodsType/goodsTypeAdd");
    }

    @ResponseBody
    @RequestMapping("/addGoods")
    public boolean addGoods(@RequestParam Map<String,Object> map) {

        GoodsType goodsType = new GoodsType();
        System.out.println(map.get("goodsTypeNumber").toString());
        System.out.println(map.get("goodsTypeName").toString());
        goodsType.setGoodsTypeNumber((String)map.get("goodsTypeNumber"));
        goodsType.setGoodsTypeName((String)map.get("goodsTypeName"));

        return goodsTypeService.addGoodsType(goodsType);
    }

    @ResponseBody
    @RequestMapping("/deleteGoodsType/{goodsTypeName}")
    public boolean deleteGoodsType(@PathVariable("goodsTypeName") String goodsTypeName) {
        return goodsTypeService.deleteGoodsType(goodsTypeName);
    }

}
