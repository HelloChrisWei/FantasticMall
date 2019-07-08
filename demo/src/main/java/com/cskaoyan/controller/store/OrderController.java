package com.cskaoyan.controller.store;

import com.cskaoyan.service.store.OrderService;
import com.cskaoyan.vo.OrderVO;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("order/list")
    @ResponseBody
    public ReadVO orderList(int page,int limit,String sort,String order,Integer orderStatusArray,String userId,String orderSn){
        return orderService.orderList(page, limit, sort, order,orderStatusArray,userId,orderSn);
    }
    @RequestMapping("order/detail")
    @ResponseBody
    public OrderVO orderDetail(Integer id){
        return orderService.orderDetail(id);
    }
}
