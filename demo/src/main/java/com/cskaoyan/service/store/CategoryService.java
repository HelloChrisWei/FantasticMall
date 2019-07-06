package com.cskaoyan.service.store;

import com.cskaoyan.bean.Category;
import com.cskaoyan.vo.CategoryReadVO;
import com.cskaoyan.vo.CategoryVO;
import com.cskaoyan.vo.L1MapVO;
import com.cskaoyan.vo.ReadVO;

public interface CategoryService {
    public CategoryReadVO<Category> categoryList();
    public ReadVO categoryUpdate(CategoryVO categoryVO);
    public L1MapVO categoryL1();
}
