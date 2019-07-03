package com.cskaoyan.mapper;

import com.cskaoyan.bean.UserFormid;
import com.cskaoyan.bean.UserFormidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFormidMapper {
    long countByExample(UserFormidExample example);

    int deleteByExample(UserFormidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFormid record);

    int insertSelective(UserFormid record);

    List<UserFormid> selectByExample(UserFormidExample example);

    UserFormid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserFormid record, @Param("example") UserFormidExample example);

    int updateByExample(@Param("record") UserFormid record, @Param("example") UserFormidExample example);

    int updateByPrimaryKeySelective(UserFormid record);

    int updateByPrimaryKey(UserFormid record);
}