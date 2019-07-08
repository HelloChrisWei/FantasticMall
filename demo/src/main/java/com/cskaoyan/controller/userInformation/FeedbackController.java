package com.cskaoyan.controller.userInformation;

import com.cskaoyan.service.userInformaitonService.FeedbackService;
import com.cskaoyan.vo.ReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping("/feedback/list")
    @ResponseBody
    public ReadVO selectFeedbackByCondition(int page,int limit,String username,Integer id){
        return feedbackService.selectFeedbackByCondition(page, limit, username, id);
    }
}
