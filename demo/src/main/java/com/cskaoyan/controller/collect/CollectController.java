package com.cskaoyan.controller.collect;

import com.cskaoyan.service.collect.CollectService;
import com.cskaoyan.vo.ReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping("/collect/list")
    @ResponseBody
    public ReadVO selectCollectByCondition(int page, int limit, Integer userId, Integer valueId){
        return collectService.selectCollectByCondition(page, limit, userId, valueId);
    }
}
