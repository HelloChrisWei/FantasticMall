package com.cskaoyan.service.userInformaitonService.impl;

import com.cskaoyan.bean.Footprint;
import com.cskaoyan.mapper.FootprintMapper;
import com.cskaoyan.service.userInformaitonService.FootprintService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FootPrintServiceImpl implements FootprintService {
    @Resource
    FootprintMapper footprintMapper;

    @Override
    public ReadVO selectFootprintByCondition(int page, int limit, Integer userId, Integer goodsId) {
        ReadVO readVO = new ReadVO();
        ResultVO<Footprint> resultVO = new ResultVO<>();
        List<Footprint> footprints;
        if (userId != null && goodsId != null){
            PageHelper.startPage(page,limit);
            footprints = footprintMapper.selectFootprintByUserIdAndGoodsId(userId, goodsId);
            PageInfo<Footprint> info = new PageInfo<>(footprints);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(footprints);
        }else if(userId != null){
            PageHelper.startPage(page,limit);
            footprints = footprintMapper.selectFootprintByUserId(userId);
            PageInfo<Footprint> info = new PageInfo<>(footprints);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(footprints);
        }else if(goodsId != null){
            PageHelper.startPage(page,limit);
            footprints = footprintMapper.selectFootprintByGoodsId( goodsId);
            PageInfo<Footprint> info = new PageInfo<>(footprints);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(footprints);
        }else {
            PageHelper.startPage(page,limit);
            footprints = footprintMapper.selectAllFootprint();
            PageInfo<Footprint> info = new PageInfo<>(footprints);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(footprints);
        }
        readVO.setData(resultVO);
        readVO.setErrno(0);
        readVO.setErrmsg("查询成功");
        return readVO;
    }
}
