package com.cskaoyan.controller;

import com.cskaoyan.bean.Data;
import com.cskaoyan.bean.Log;
import com.cskaoyan.bean.ResponseVO;
import com.cskaoyan.service.systemManager.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/log/list")
    @ResponseBody
    public ResponseVO list(int page, int limit, String username) {
        int offset = (page - 1) * limit;
        if (username == null) {
            List<Log> logs = logService.selectLogByPage(limit, offset);
            Data<Log> logData = new Data<>();
            logData.setTotal(logs == null ? 0 : logs.size());
            logData.setItems(logs);
            return new ResponseVO(logData, "成功", 0);
        } else {
            List<Log> logs = logService.selectLogByUserName(username, limit, offset);
            Data<Log> logData = new Data<>();
            logData.setItems(logs);
            logData.setTotal(logs == null ? 0 : logs.size());
            return new ResponseVO(logData, "成功", 0);
        }
    }
}
