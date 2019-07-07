package com.cskaoyan.service.userInformaitonService.impl;

import com.cskaoyan.bean.SearchHistory;
import com.cskaoyan.mapper.SearchHistoryMapper;
import com.cskaoyan.service.userInformaitonService.SearchHistoryService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    @Resource
    SearchHistoryMapper historyMapper;

    @Override
    public ReadVO selectSearchHistoryByCondition(int page, int limit, Integer userId, String keyword) {
        ReadVO readVO = new ReadVO();
        ResultVO<SearchHistory> resultVO = new ResultVO<>();
        List<SearchHistory> searchHistories;

        if (userId != null && keyword != null){
            keyword = "%" + keyword + "%";
            PageHelper.startPage(page,limit);
            searchHistories = historyMapper.selectSearchHistoryByUserIdAndKeyword(keyword,userId);
            PageInfo<SearchHistory> info = new PageInfo<>(searchHistories);
            int total = (int) info.getTotal();
            resultVO.setItems(searchHistories);
            resultVO.setTotal(total);
        }else if (userId != null){
            PageHelper.startPage(page,limit);
            searchHistories = historyMapper.selectSearchHistoryByUserId(userId);
            PageInfo<SearchHistory> info = new PageInfo<>(searchHistories);
            int total = (int) info.getTotal();
            resultVO.setItems(searchHistories);
            resultVO.setTotal(total);
        }else if (keyword != null){
            keyword = "%" + keyword + "%";
            PageHelper.startPage(page,limit);
            searchHistories = historyMapper.selectSearchHistoryByKeyword(keyword);
            PageInfo<SearchHistory> info = new PageInfo<>(searchHistories);
            int total = (int) info.getTotal();
            resultVO.setItems(searchHistories);
            resultVO.setTotal(total);
        }else {
            PageHelper.startPage(page,limit);
            searchHistories = historyMapper.selectSearchAllHistory();
            PageInfo<SearchHistory> info = new PageInfo<>(searchHistories);
            int total = (int) info.getTotal();
            resultVO.setItems(searchHistories);
            resultVO.setTotal(total);
        }
        readVO.setData(resultVO);
        readVO.setErrmsg("查询成功");
        readVO.setErrno(0);
        return readVO;
    }
}
