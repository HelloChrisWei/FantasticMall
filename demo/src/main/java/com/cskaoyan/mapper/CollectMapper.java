package com.cskaoyan.mapper;

import com.cskaoyan.bean.Collect;
import com.cskaoyan.bean.CollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectMapper {
    long countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    List<Collect> selectAllCollect();

    List<Collect> selectCollectByUserIdAndValueId(@Param("userId") Integer userId, @Param("valueId") Integer valueId);

    List<Collect> selectCollectByUserId(@Param("userId") Integer userId);

    List<Collect> selectCollectByValueId(@Param("valueId") Integer valueId);
}