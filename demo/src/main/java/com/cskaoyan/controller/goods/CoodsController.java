package com.cskaoyan.controller.goods;

import com.cskaoyan.bean.EasyDataResult;
import com.cskaoyan.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("goods/list")
    @ResponseBody
    public EasyDataResult goodsList(int page,int roes){
        return goodsService.selectAllGoodsByPage(page,roes);
    }

    @RequestMapping("goods/detail")
    @ResponseBody
    public String goodsDetail(String id){
        return null;
    }
}
