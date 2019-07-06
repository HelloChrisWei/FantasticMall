package com.cskaoyan.controller.goods;
import com.cskaoyan.bean.goods.Goods;
import com.cskaoyan.bean.goods.GoodsAddData;
import com.cskaoyan.bean.goods.GoodsUpDateData;
import com.cskaoyan.service.goods.GoodsService;
import com.cskaoyan.vo.GoodsHanderVO;
import com.cskaoyan.vo.GoodsPreviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class CoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods/list")
    @ResponseBody
    public GoodsPreviewVO  selectGoodsList(GoodsHanderVO handerVO,Integer goodsSn,String name){
        GoodsPreviewVO goodsList = goodsService.selectGoodsList(handerVO, goodsSn, name);
        return goodsList;
    }

    @RequestMapping("/goods/detail")
    @ResponseBody
    public GoodsPreviewVO selectGoodsDetialById(Integer id){
        GoodsPreviewVO goodsDetail = goodsService.selectGoodsDetail(id);
        return goodsDetail;
    }

    @RequestMapping("/goods/catAndBrand")
    @ResponseBody
    public GoodsPreviewVO selectCatAndBrand(){
        GoodsPreviewVO catAnBrand = goodsService.selectCatAnBrand();
        return catAnBrand;
    }

    @RequestMapping("/goods/update")
    @ResponseBody
    public GoodsPreviewVO goodsUpdate(@RequestBody GoodsUpDateData goodsUpDateData){
        GoodsPreviewVO updateGoods = goodsService.updateGoods( goodsUpDateData);
        return updateGoods;
    }

    @RequestMapping("/goods/delete")
    @ResponseBody
    public GoodsPreviewVO goodsDelete(@RequestBody Goods goods){
        GoodsPreviewVO goodsById = goodsService.deleteGoodsById(goods);
        return goodsById;

    }

    @RequestMapping("/goods/create")
    @ResponseBody
    public GoodsPreviewVO goodsCreate(@RequestBody GoodsAddData goodsAddData){
        GoodsPreviewVO addGoods = goodsService.addGoods(goodsAddData);
        return addGoods;
    }


}
