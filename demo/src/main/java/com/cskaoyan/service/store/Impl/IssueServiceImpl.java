package com.cskaoyan.service.store.Impl;

import com.cskaoyan.bean.Issue;
import com.cskaoyan.mapper.IssueMapper;
import com.cskaoyan.service.store.IssueService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.cskaoyan.vo.SingleReadVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class IssueServiceImpl  implements IssueService {
    @Autowired
    IssueMapper issueMapper;

    @Override
    public ReadVO<Issue> IssueList(int page, int limit, String question ,String sort, String order){
        PageHelper.startPage(page,limit);
        ReadVO<Issue> readVO = new ReadVO<>();
        ResultVO<Issue> vo = new ResultVO<>();
        String jquestion = question;

        try{
            if (question!=null){
                jquestion = "%"+question+"%";
            }
            List<Issue> list = issueMapper.select(jquestion,sort,order);
            int i = (int)issueMapper.count(jquestion);
            vo.setItems(list);
            vo.setTotal(i);
            readVO.setData(vo);
            readVO.setErrmsg("成功");
            readVO.setErrno(0);
            return readVO;
        }catch (Exception e){
            readVO.setErrmsg("失败");
            readVO.setErrno(1);
            return readVO;
        }
    }
    @Override
    public SingleReadVO issueCreate(String quetion, String answer){
        SingleReadVO<Issue> vo = new SingleReadVO<>();
        Issue issue = new Issue();
        issue.setAnswer(answer);
        issue.setQuestion(quetion);
        issue.setDeleted(false);
        issue.setAddTime(new Date());
        issue.setUpdateTime(new Date());
        issue.setDeleted(false);
        try {
            issueMapper.insert(issue);
            String sort = "add_time";
            String order = "desc";
            String jquestion = quetion;
            if (quetion!=null){
                jquestion = "%"+quetion+"%";
            }
            List<Issue> list = issueMapper.select(jquestion, sort, order);
            Issue issue1 = list.get(0);
            vo.setData(issue1);
            vo.setErrno(0);
            vo.setErrmsg("成功");
            return vo;
        }catch (Exception e){
            vo.setErrno(1);
            vo.setErrmsg("失败");
            return vo;
        }
    }
    @Override
    public SingleReadVO issueUpdate( Issue issue){
        SingleReadVO<Issue> vo = new SingleReadVO<>();
        issue.setUpdateTime(new Date());
        try {
            issueMapper.updateByPrimaryKey(issue);
            Issue issue1 = issueMapper.selectByPrimaryKey(issue.getId());
            vo.setData(issue1);
            vo.setErrmsg("成功");
            vo.setErrno(0);
            return vo;
        }catch (Exception e){
            vo.setErrmsg("失败");
            vo.setErrno(1);
            return vo;
        }
    }

}
