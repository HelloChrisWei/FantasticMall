package com.cskaoyan.service.statement;

import com.cskaoyan.vo.StatementReadVo;

import java.util.List;
import java.util.Map;

public interface UserStatementService {
    List<Map> countUsers();
    List<Map> countOrders();
    List<Map> countGoods();
}
