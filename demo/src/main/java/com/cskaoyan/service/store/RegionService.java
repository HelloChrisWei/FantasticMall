package com.cskaoyan.service.store;

import com.cskaoyan.bean.Region;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.StoreVO;

public interface RegionService {
    public StoreVO<Region> regionList();
}
