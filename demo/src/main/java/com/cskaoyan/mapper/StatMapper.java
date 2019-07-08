package com.cskaoyan.mapper;

import java.util.List;
import java.util.Map;


public interface StatMapper {
    List<Map> countUsers();
    List<Map> countOrders();
    List<Map> countGoods();
}
