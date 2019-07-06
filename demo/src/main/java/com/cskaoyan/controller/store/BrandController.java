package com.cskaoyan.controller.store;

import com.cskaoyan.bean.Brand;
import com.cskaoyan.service.store.BrandService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.SingleReadVO;
import com.cskaoyan.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrandController {
    @Autowired
    BrandService brandService;

    @RequestMapping("brand/list")
    @ResponseBody
    public ReadVO brandList(int page, int limit, String id, String name, String sort, String desc){
        return brandService.brandList(page,limit,id,name,sort,desc);
    }
    //品牌制造商界面修改功能
    @RequestMapping("brand/update")
    @ResponseBody
    public SingleReadVO<Brand> brandUpdate(@RequestBody Brand brand){
        return brandService.brandUpdate(brand);
    }
    @RequestMapping("brand/delete")
    @ResponseBody
    public SingleReadVO brandDelect(@RequestBody Brand brand){
        return brandService.brandDelete(brand);
    }
}
