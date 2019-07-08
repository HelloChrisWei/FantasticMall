package com.cskaoyan.service.goods;


import com.cskaoyan.bean.goods.Goods;
import com.cskaoyan.bean.goods.GoodsAddData;
import com.cskaoyan.bean.goods.GoodsUpDateData;
import com.cskaoyan.vo.GoodsHanderVO;
import com.cskaoyan.vo.GoodsPreviewVO;

public interface GoodsService {
    GoodsPreviewVO selectGoodsList(GoodsHanderVO handerVO, Integer goodsSn, String name);

    GoodsPreviewVO selectGoodsDetail(Integer id);

    GoodsPreviewVO selectCatAnBrand();

    GoodsPreviewVO updateGoods(GoodsUpDateData goodsUpDateData);

    GoodsPreviewVO deleteGoodsById(Goods goods);

    GoodsPreviewVO addGoods(GoodsAddData goodsAddData);
}
