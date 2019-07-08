package com.cskaoyan.mapper;

import com.cskaoyan.bean.MallSystem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MallSystemMapper {
    List<MallSystem> selectMallSystemByMall(@Param("prefix") String prefix);

    int updateMallSystem(MallSystem mallSystem);
}
