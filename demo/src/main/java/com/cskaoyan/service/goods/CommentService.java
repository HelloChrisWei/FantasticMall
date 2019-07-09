package com.cskaoyan.service.goods;


import com.cskaoyan.bean.goods.Comment;
import com.cskaoyan.vo.GoodsHanderVO;
import com.cskaoyan.vo.GoodsPreviewVO;

public interface CommentService {
    GoodsPreviewVO conmentList(GoodsHanderVO handerVO,Integer userId,Integer valueId);
    GoodsPreviewVO commentDeleteById(Comment comment);
}
