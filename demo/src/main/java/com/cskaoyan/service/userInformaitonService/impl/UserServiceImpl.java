package com.cskaoyan.service.userInformaitonService.impl;

import com.cskaoyan.bean.EasyDataResult;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.service.userInformaitonService.UserService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.cskaoyan.vo.SingleReadVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public ReadVO selectUser(int page, int limit, String username,String mobile) {
        ReadVO readVO = new ReadVO<>();
        ResultVO<User> resultVO = new ResultVO<>();
        List<User> users;
        if (username != null && mobile != null){
            username = "%" + username + "%";
            mobile = "%" + mobile + "%";
            PageHelper.startPage(page,limit);
            users = userMapper.selectUserByUserUserAndMobile(username, mobile);
            PageInfo<User> info = new PageInfo<>(users);
            int total = (int) info.getTotal();
            resultVO.setItems(users);
            resultVO.setTotal(total);
        }else if (username != null){
            username = "%" + username + "%";
            PageHelper.startPage(page,limit);
            users = userMapper.selectUserByUsername(username);
            PageInfo<User> info = new PageInfo<>(users);
            int total = (int) info.getTotal();
            resultVO.setItems(users);
            resultVO.setTotal(total);
        }else if (mobile != null){
            mobile = "%" + mobile + "%";
            PageHelper.startPage(page,limit);
            users = userMapper.selectUserByUserMobile(mobile);
            PageInfo<User> info = new PageInfo<>(users);
            int total = (int) info.getTotal();
            resultVO.setItems(users);
            resultVO.setTotal(total);
        }
        else {
            PageHelper.startPage(page, limit);
            users = userMapper.selectAllUserByPage();
            PageInfo<User> info = new PageInfo<>(users);
            int total = (int) info.getTotal();
            resultVO.setItems(users);
            resultVO.setTotal(total);
        }
        readVO.setData(resultVO);
        readVO.setErrmsg("查询成功");
        readVO.setErrno(0);
        return readVO;
    }
}
