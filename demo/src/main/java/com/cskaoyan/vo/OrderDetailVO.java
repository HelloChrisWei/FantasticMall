package com.cskaoyan.vo;


import com.cskaoyan.bean.Order;
import com.cskaoyan.bean.User;
import com.cskaoyan.bean.goods.Goods;

public class OrderDetailVO {
    Order order;

    Goods[] orderGoods;

    User user;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Goods[] getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(Goods[] orderGoods) {
        this.orderGoods = orderGoods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
