package com.cskaoyan.controller.userInformation;

import com.cskaoyan.service.userInformaitonService.SearchHistoryService;
import com.cskaoyan.vo.ReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchHistoryController {
    @Autowired
    SearchHistoryService historyService;

    @RequestMapping("/history/list")
    @ResponseBody
    public ReadVO selectSearchHistoryByCondition(int page,int limit,Integer userId,String keyword){
        return historyService.selectSearchHistoryByCondition(page, limit, userId, keyword);
    }
}
