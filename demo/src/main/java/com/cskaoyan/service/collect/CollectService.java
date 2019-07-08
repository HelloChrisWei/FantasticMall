package com.cskaoyan.service.collect;

import com.cskaoyan.vo.ReadVO;

public interface CollectService {
    ReadVO selectCollectByCondition(int page, int limit, Integer userId, Integer valueId);
}
