package com.cskaoyan.service.store;

import com.cskaoyan.bean.Category;
import com.cskaoyan.vo.*;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoryService {
    public CategoryReadVO<Category> categoryList();
    public ReadVO categoryUpdate(CategoryVO categoryVO);
    public L1MapVO categoryL1();
    public SingleReadVO categoryCreate( Category category);
    public ReadVO categoryDelete(CategoryVO categoryVO);
}
