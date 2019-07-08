package com.cskaoyan.service.store;

import com.cskaoyan.vo.OrderVO;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.StoreVO;

public interface OrderService {
    public ReadVO orderList(int page,int limit,String sort,String order,Integer orderStatusArray,String userId,String orderSn);
    public OrderVO orderDetail(Integer id);
}
