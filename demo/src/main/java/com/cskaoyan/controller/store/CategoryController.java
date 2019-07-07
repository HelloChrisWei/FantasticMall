package com.cskaoyan.controller.store;

import com.cskaoyan.bean.Category;
import com.cskaoyan.service.store.CategoryService;
import com.cskaoyan.vo.CategoryReadVO;
import com.cskaoyan.vo.CategoryVO;
import com.cskaoyan.vo.L1MapVO;
import com.cskaoyan.vo.ReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("category/list")
    @ResponseBody
    public CategoryReadVO<Category> categoryList(){
        return categoryService.categoryList();
    }
    @RequestMapping("category/l1")
    @ResponseBody
    public L1MapVO categoryL1(){
        return categoryService.categoryL1();
    }
    @RequestMapping("category/update")
    @ResponseBody
    public ReadVO categoryUpdate(@RequestBody CategoryVO categoryVO){
        return categoryService.categoryUpdate(categoryVO);
    }
}
