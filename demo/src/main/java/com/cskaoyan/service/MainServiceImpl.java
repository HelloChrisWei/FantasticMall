package com.cskaoyan.service;

import com.cskaoyan.mapper.MainMapper;
import com.cskaoyan.service.MainService;
import com.cskaoyan.util.ReadVO;
import com.cskaoyan.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainMapper mainMapper;

    @Override
    public ReadVO readStatic() {
        int goodsTotal = mainMapper.readGoodsTotal();
        int orderTotal = mainMapper.readOrderTotal();
        int productTotal = mainMapper.readProductTotal();
        int userTotal = mainMapper.readUserTotal();

        ReadVO readVO = new ReadVO();
        ResultVO resultVo = new ResultVO();

        resultVo.setGoodsTotal(goodsTotal);
        resultVo.setOrderTotal(orderTotal);
        resultVo.setProductTotal(productTotal);
        resultVo.setUserTotal(userTotal);

        readVO.setData(resultVo);
        readVO.setErrno(0);
        readVO.setErrmsg("成功");

        return readVO;
    }
}
