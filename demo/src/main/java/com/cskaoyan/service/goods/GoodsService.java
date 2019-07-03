package com.cskaoyan.service.goods;

import com.cskaoyan.bean.EasyDataResult;
import com.cskaoyan.bean.Goods;

public interface GoodsService {
    //查出数据库中所有数据
    EasyDataResult<Goods> selectAllGoodsByPage(int page,int rows);
}
