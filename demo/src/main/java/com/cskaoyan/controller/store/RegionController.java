package com.cskaoyan.controller.store;

import com.cskaoyan.bean.Region;
import com.cskaoyan.service.store.RegionService;
import com.cskaoyan.vo.RegionReadVO;
import com.cskaoyan.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegionController {
    @Autowired
    RegionService regionService;
    //在展示页显示所有的行政区域信息
    @RequestMapping("region/list")
    @ResponseBody
    public StoreVO<Region> regionList(){
        StoreVO<Region> regionStoreVO = regionService.regionList();
        return regionStoreVO;
    }
}
