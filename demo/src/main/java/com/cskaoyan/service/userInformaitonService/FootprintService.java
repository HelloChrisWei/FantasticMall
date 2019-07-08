package com.cskaoyan.service.userInformaitonService;

import com.cskaoyan.vo.ReadVO;

public interface FootprintService {
    ReadVO selectFootprintByCondition(int page,int limit,Integer userId,Integer goodsId);
}
