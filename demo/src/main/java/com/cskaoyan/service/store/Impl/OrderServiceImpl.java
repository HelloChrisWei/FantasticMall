package com.cskaoyan.service.store.Impl;


import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.OrderExample;
import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.OrderMapper;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.mapper.goods.GoodsMapper;
import com.cskaoyan.service.store.OrderService;
import com.cskaoyan.vo.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public ReadVO orderList(int page,int limit,String sort,String order,Integer orderStatusArray,String userId,String orderSn) {
        PageHelper.startPage(page,limit);
        ReadVO<Order> vo = new ReadVO<Order>();
        ResultVO<Order> vo1 = new ResultVO<>();
        String juserId = userId;
        String jorderSn = orderSn;
        if (userId!=null) {
            juserId = "%" + userId + "%";
        }
        if (orderSn!=null) {
            jorderSn = "%" + orderSn + "%";
        }
        try {
            List<Order> orders = orderMapper.select(sort,order,orderStatusArray,juserId,jorderSn);
            int l = (int)orderMapper.count(orderStatusArray, juserId, jorderSn);
            vo1.setTotal(l);
            vo1.setItems(orders);
            vo.setData(vo1);
            vo.setErrno(0);
            vo.setErrmsg("成功");
            return vo;
        }catch (Exception e){
            vo.setErrno(1);
            vo.setErrmsg("查找有误");
            return vo;
        }
    }

    @Override
    public OrderVO orderDetail(Integer id) {
        OrderVO vo = new OrderVO();
        OrderDetailVO vo1 = new OrderDetailVO();
        //先获取order信息，再获取goods信息，最后获取user信息
        try {
            Order order = orderMapper.selectByPrimaryKey(id);
            vo1.setOrder(order);
        /*    String orderSn = order.getOrderSn();
            Integer integer = Integer.getInteger(orderSn);
            Goods goods = goodsMapper.selectByPrimaryKey(integer);
            Goods[] goods1 = new Goods[100];
            goods1[0] = goods;
            vo1.setOrderGoods(goods1);*/
            User user = userMapper.selectByPrimaryKey(order.getUserId());
            vo1.setUser(user);
            vo.setData(vo1);
            vo.setErrno(0);
            vo.setErrmsg("成功");
            return vo;
        }catch (Exception e){
            vo.setErrno(1);
            vo.setErrmsg("查看失败");
            return vo;
        }
    }
}
