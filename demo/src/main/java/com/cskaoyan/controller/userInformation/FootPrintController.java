package com.cskaoyan.controller.userInformation;

import com.cskaoyan.service.userInformaitonService.FootprintService;
import com.cskaoyan.vo.ReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FootPrintController {
    @Autowired
    FootprintService footprintService;

    @RequestMapping("/footprint/list")
    @ResponseBody
    public ReadVO selectFootPrintByCondition(int page, int limit, Integer userId, Integer goodsId){
        return footprintService.selectFootprintByCondition(page, limit, userId, goodsId);
    }
}
