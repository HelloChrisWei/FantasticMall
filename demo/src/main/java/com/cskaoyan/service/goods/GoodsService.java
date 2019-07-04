package com.cskaoyan.service.goods;

import com.cskaoyan.bean.EasyDataResult;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.vo.ResultVO;

public interface GoodsService {
    //查出数据库中所有数据
    ResultVO<Goods> selectAllGoodsByPage(int page, int rows);
}
