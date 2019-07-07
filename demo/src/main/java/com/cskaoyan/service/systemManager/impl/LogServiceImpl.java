package com.cskaoyan.service.systemManager.impl;

import com.cskaoyan.bean.Log;
import com.cskaoyan.mapper.LogMapper;
import com.cskaoyan.service.systemManager.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> selectLogByPage(int limit, int offset) {
        return logMapper.selectLogByPage(limit, offset);
    }

    @Override
    public List<Log> selectLogByUserName(String username, int limit, int offset) {
        return logMapper.selectLogByUserName(username, limit, offset);
    }
}
