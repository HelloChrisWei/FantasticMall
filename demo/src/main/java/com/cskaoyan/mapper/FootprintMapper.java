package com.cskaoyan.mapper;

import com.cskaoyan.bean.Footprint;
import com.cskaoyan.bean.FootprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.tags.BindTag;

public interface FootprintMapper {
    long countByExample(FootprintExample example);

    int deleteByExample(FootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Footprint record);

    int insertSelective(Footprint record);

    List<Footprint> selectByExample(FootprintExample example);

    Footprint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByExample(@Param("record") Footprint record, @Param("example") FootprintExample example);

    int updateByPrimaryKeySelective(Footprint record);

    int updateByPrimaryKey(Footprint record);

    List<Footprint> selectAllFootprint();

    List<Footprint> selectFootprintByUserIdAndGoodsId(@Param("userId") Integer userId, @Param("goodsId") Integer goodsId);

    List<Footprint> selectFootprintByUserId(@Param("userId") Integer userId);

    List<Footprint> selectFootprintByGoodsId( @Param("goodsId") Integer goodsId);
}