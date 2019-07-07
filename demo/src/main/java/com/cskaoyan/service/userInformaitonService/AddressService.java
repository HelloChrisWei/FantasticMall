package com.cskaoyan.service.userInformaitonService;

import com.cskaoyan.vo.ReadVO;

public interface AddressService {
    ReadVO seleceAddressByCondition(int page, int limit, Integer userId, String name);
}
