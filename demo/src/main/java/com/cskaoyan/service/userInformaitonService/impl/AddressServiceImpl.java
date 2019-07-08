package com.cskaoyan.service.userInformaitonService.impl;

import com.cskaoyan.bean.Address;
import com.cskaoyan.mapper.AddressMapper;
import com.cskaoyan.service.userInformaitonService.AddressService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;

    @Override
    public ReadVO seleceAddressByCondition(int page, int limit, Integer userId, String name) {
        ReadVO readVO = new ReadVO();

        ResultVO<Address> resultVO = new ResultVO<>();

        List<Address> addresses;

        if(userId != null && name != null){
            PageHelper.startPage(page,limit);
            name = "%" + name + "%";
            addresses = addressMapper.selectAddressByUserIdAndName(userId,name);
            PageInfo<Address> info = new PageInfo<>(addresses);
            int total = (int) info.getTotal();
            resultVO.setItems(addresses);
            resultVO.setTotal(total);
        }else if (userId != null){
            PageHelper.startPage(page,limit);
            addresses = addressMapper.selectAddressByUserId(userId);
            PageInfo<Address> info = new PageInfo<>(addresses);
            int total = (int) info.getTotal();
            resultVO.setItems(addresses);
            resultVO.setTotal(total);
        }else if (name != null){
            PageHelper.startPage(page,limit);
            name = "%" + name + "%";
            addresses = addressMapper.selectAddressByName(name);
            PageInfo<Address> info = new PageInfo<>(addresses);
            int total = (int) info.getTotal();
            resultVO.setItems(addresses);
            resultVO.setTotal(total);
        }else {
            PageHelper.startPage(page,limit);
            addresses = addressMapper.selectAllAddress();
            PageInfo<Address> info = new PageInfo<>(addresses);
            int total = (int) info.getTotal();
            resultVO.setItems(addresses);
            resultVO.setTotal(total);
        }
        readVO.setData(resultVO);
        readVO.setErrno(0);
        readVO.setErrmsg("查询成功");
        return readVO;
    }
}
