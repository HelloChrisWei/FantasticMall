package com.cskaoyan.controller;

import com.cskaoyan.service.statement.UserStatementService;
import com.cskaoyan.vo.CountVo;
import com.cskaoyan.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class StatementController {
    @Autowired
    UserStatementService statService;

    @RequestMapping("/stat/user")
    @ResponseBody
    public QueryVo user(){
        String[] columns = {"day", "users"};
        List<Map> rows = statService.countUsers();
        return basicCountStatVo(columns, rows);
    }

    @RequestMapping("/stat/order")
    @ResponseBody
    public QueryVo order(){
        String[] columns = {"day", "orders", "customers", "amount", "pcr"};
        List<Map> rows = statService.countOrders();
        return basicCountStatVo(columns,rows);
    }

    @RequestMapping("/stat/goods")
    @ResponseBody
    public QueryVo goods(){
        String[] columns = {"day", "orders", "products", "amount"};
        List<Map> rows = statService.countGoods();
        return basicCountStatVo(columns,rows);
    }

    public QueryVo basicCountStatVo(String[] columns, List<Map> rows){
        CountVo countVo = new CountVo(columns, rows);
        return new QueryVo(0, countVo,"成功");
    }
}
