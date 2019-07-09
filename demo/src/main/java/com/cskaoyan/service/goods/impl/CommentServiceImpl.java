package com.cskaoyan.service.goods.impl;

import com.cskaoyan.bean.goods.Comment;
import com.cskaoyan.bean.goods.CommentExample;
import com.cskaoyan.mapper.goods.CommentMapper;
import com.cskaoyan.service.goods.CommentService;
import com.cskaoyan.vo.GoodsHanderVO;
import com.cskaoyan.vo.GoodsPreviewVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public GoodsPreviewVO conmentList(GoodsHanderVO handerVO, Integer userId, Integer valueId) {
        CommentExample example = new CommentExample();
        //自定义查询
        CommentExample.Criteria criteria = example.createCriteria();
        if (userId !=null){
            criteria.andUserIdEqualTo(userId);
        }else if (valueId !=null){
            criteria.andValueIdEqualTo(valueId);
        }
        //分页
        PageHelper.startPage(handerVO.getPage(),handerVO.getLimit());
        //将查询的数据封装成一个list
        List<Comment> comments = commentMapper.selectByExample(example);
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        int total = (int) pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",comments);
        map.put("total",total);
        return new GoodsPreviewVO("成功",0,map);
    }

    @Override
    public GoodsPreviewVO commentDeleteById(Comment comment) {
        GoodsPreviewVO previewVO = new GoodsPreviewVO();
        try {
            int i = commentMapper.deleteByPrimaryKey(comment.getId());
            if (i==1){
                previewVO.setErrmsg("删除成功");
                previewVO.setErrno(0);
            }
        }catch (Exception e){
            previewVO.setErrmsg("删除失败");
            previewVO.setErrno(500);
        }

        return previewVO;
    }


}
