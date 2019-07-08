package com.cskaoyan.service.userInformaitonService;

import com.cskaoyan.vo.ReadVO;

public interface SearchHistoryService {
    ReadVO selectSearchHistoryByCondition(int page,int limit,Integer userId,String keyword);
}
