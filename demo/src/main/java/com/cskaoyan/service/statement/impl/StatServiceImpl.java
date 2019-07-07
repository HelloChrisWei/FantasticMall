package com.cskaoyan.service.statement.impl;

import com.cskaoyan.mapper.StatMapper;
import com.cskaoyan.service.statement.UserStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@Service
public class StatServiceImpl implements UserStatementService {

    @Resource
    StatMapper statMapper;

    @Override
    public List<Map> countUsers(){
        return statMapper.countUsers();
    }

    @Override
    public List<Map> countOrders(){
        return statMapper.countOrders();
    }

    @Override
    public List<Map> countGoods(){
        return statMapper.countGoods();
    }
}
