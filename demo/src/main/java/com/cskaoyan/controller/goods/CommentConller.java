package com.cskaoyan.controller.goods;

import com.cskaoyan.bean.Comment;
import com.cskaoyan.bean.goods.Goods;
import com.cskaoyan.service.goods.CommentService;
import com.cskaoyan.vo.GoodsHanderVO;
import com.cskaoyan.vo.GoodsPreviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentConller {
    @Autowired
    CommentService commentService;
    @RequestMapping("/comment/list")
    public GoodsPreviewVO commentList(GoodsHanderVO handerVO,Integer userId,Integer valueId){
        GoodsPreviewVO conmentList = commentService.conmentList(handerVO, userId, valueId);
        return conmentList;
    }
    @RequestMapping("/comment/delete")
    public GoodsPreviewVO commentDelete(@RequestBody Comment comment){
        GoodsPreviewVO deleteById = commentService.commentDeleteById(comment);
        return deleteById;
    }
}
