package com.cskaoyan.service.userInformaitonService.impl;

import com.cskaoyan.bean.Feedback;
import com.cskaoyan.mapper.FeedbackMapper;
import com.cskaoyan.service.userInformaitonService.FeedbackService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    FeedbackMapper feedbackMapper;
    @Override
    public ReadVO selectFeedbackByCondition(int page, int limit, String username, Integer id) {
        ReadVO readVO = new ReadVO();
        ResultVO<Feedback> resultVO = new ResultVO<>();
        List<Feedback> feedbacks;
        if (id != null && username != null){
            username = "%" + username + "%";
            PageHelper.startPage(page,limit);
            feedbacks = feedbackMapper.selectFeedBackByUsernameAndFeedBackId(username, id);
            PageInfo<Feedback> info = new PageInfo<>(feedbacks);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(feedbacks);
        }else if (id != null){
            PageHelper.startPage(page,limit);
            feedbacks = feedbackMapper.selectFeedBackByFeedBackId(id);
            PageInfo<Feedback> info = new PageInfo<>(feedbacks);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(feedbacks);
        }else if (username != null){
            username = "%" + username + "%";
            PageHelper.startPage(page,limit);
            feedbacks = feedbackMapper.selectFeedBackByUsername(username);
            PageInfo<Feedback> info = new PageInfo<>(feedbacks);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(feedbacks);
        }else {
            PageHelper.startPage(page,limit);
            feedbacks = feedbackMapper.selectAllFeedback();
            PageInfo<Feedback> info = new PageInfo<>(feedbacks);
            int total = (int) info.getTotal();
            resultVO.setTotal(total);
            resultVO.setItems(feedbacks);
        }
        readVO.setData(resultVO);
        readVO.setErrmsg("查询成功");
        readVO.setErrno(0);
        return readVO;
    }
}
