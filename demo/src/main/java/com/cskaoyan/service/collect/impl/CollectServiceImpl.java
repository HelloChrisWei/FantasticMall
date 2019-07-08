package com.cskaoyan.service.collect.impl;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.mapper.CollectMapper;
import com.cskaoyan.service.collect.CollectService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    CollectMapper collectMapper;

    @Override
    public ReadVO selectCollectByCondition(int page, int limit, Integer userId, Integer valueId) {
        ReadVO readVO = new ReadVO();
        ResultVO<Collect> resultVO = new ResultVO<>();
        List<Collect> collects;
        if(userId != null && valueId != null){
            PageHelper.startPage(page,limit);
            collects = collectMapper.selectCollectByUserIdAndValueId(userId,valueId);
            PageInfo<Collect> info = new PageInfo<>(collects);
            int total = (int) info.getTotal();
            resultVO.setItems(collects);
            resultVO.setTotal(total);
        }else if(userId != null){
            PageHelper.startPage(page,limit);
            collects = collectMapper.selectCollectByUserId(userId);
            PageInfo<Collect> info = new PageInfo<>(collects);
            int total = (int) info.getTotal();
            resultVO.setItems(collects);
            resultVO.setTotal(total);
        }else if (valueId != null){
            PageHelper.startPage(page,limit);
            collects = collectMapper.selectCollectByValueId(valueId);
            PageInfo<Collect> info = new PageInfo<>(collects);
            int total = (int) info.getTotal();
            resultVO.setItems(collects);
            resultVO.setTotal(total);
        }else {
            PageHelper.startPage(page,limit);
            collects = collectMapper.selectAllCollect();
            PageInfo<Collect> info = new PageInfo<>(collects);
            int total = (int) info.getTotal();
            resultVO.setItems(collects);
            resultVO.setTotal(total);
        }

        readVO.setData(resultVO);
        readVO.setErrmsg("查询成功");
        readVO.setErrno(0);
        return readVO;
    }
}
