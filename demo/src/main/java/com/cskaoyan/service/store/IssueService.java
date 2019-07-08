package com.cskaoyan.service.store;

import com.cskaoyan.bean.Issue;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.SingleReadVO;
import org.springframework.web.bind.annotation.RequestBody;

public interface IssueService {
    public ReadVO<Issue> IssueList(int page, int limit,String question, String sort, String order);
    public SingleReadVO issueCreate(String quetion, String answer);
    public SingleReadVO issueUpdate( Issue issue);
}
