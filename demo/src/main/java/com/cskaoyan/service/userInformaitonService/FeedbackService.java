package com.cskaoyan.service.userInformaitonService;

import com.cskaoyan.vo.ReadVO;

public interface FeedbackService {
    ReadVO selectFeedbackByCondition(int page,int limit,String username,Integer id);
}
