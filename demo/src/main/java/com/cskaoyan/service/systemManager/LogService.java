package com.cskaoyan.service.systemManager;

import com.cskaoyan.bean.Log;

import java.util.List;

public interface LogService {

    List<Log> selectLogByPage(int limit, int offset);

    List<Log> selectLogByUserName(String username, int limit, int offset);

}
