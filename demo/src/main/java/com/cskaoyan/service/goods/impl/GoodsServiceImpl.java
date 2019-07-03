package com.cskaoyan.service.goods.impl;
import com.cskaoyan.bean.EasyDataResult;
import com.cskaoyan.bean.Goods;
import com.cskaoyan.mapper.GoodsMapper;
import com.cskaoyan.service.goods.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public EasyDataResult<Goods> selectAllGoodsByPage(int page, int rows) {
        EasyDataResult<Goods> result = new EasyDataResult<Goods>();
        //PageHelper接收前端数据
        PageHelper.startPage(page,rows);
        //查询所有数据封装成一个list
        List<Goods> goods  = goodsMapper.selectAllGoodsByPage();
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        //查询总条目数
        int  total = (int) pageInfo.getTotal();
        //将总条目数封装成一个Javabean给前端用户
        result.setTotal(total);
        result.setRows(goods);
        return result;
    }
}
