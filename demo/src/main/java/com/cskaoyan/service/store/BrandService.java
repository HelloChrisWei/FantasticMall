package com.cskaoyan.service.store;

import com.cskaoyan.bean.Brand;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.SingleReadVO;
import com.cskaoyan.vo.StoreVO;
import org.springframework.stereotype.Service;


public interface BrandService {
    public ReadVO brandList(int page, int limit,String id,String name, String sort, String desc);
    public SingleReadVO<Brand> brandUpdate(Brand brand);
    public SingleReadVO brandDelete(Brand brand);
}
