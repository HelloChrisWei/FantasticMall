package com.cskaoyan.controller.store;


import com.cskaoyan.bean.Issue;
import com.cskaoyan.service.store.IssueService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.cskaoyan.vo.SingleReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class issueController {
    @Autowired
    IssueService issueService;

    @RequestMapping("issue/list")
    @ResponseBody
    public ReadVO<Issue> IssueList(int page, int limit,String question, String sort, String order){
        return issueService.IssueList(page,limit,question,sort,order);
    }
    @RequestMapping("issue/create")
    @ResponseBody
    public SingleReadVO issueCreate(@RequestBody HashMap map){
        String answer = map.get("answer").toString();
        String question1 = map.get("question").toString();
        return issueService.issueCreate(question1,answer);
    }
    @RequestMapping("issue/update")
    @ResponseBody
    public SingleReadVO issueUpdate(@RequestBody Issue issue){
        return issueService.issueUpdate(issue);
    }
    /*@RequestMapping("issue/delete")
    @ResponseBody
    public SingleReadVO*/
}
