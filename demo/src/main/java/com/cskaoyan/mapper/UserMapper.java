package com.cskaoyan.mapper;

import com.cskaoyan.bean.User;
import com.cskaoyan.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAllUserByPage();

    List<User> selectUserByUsername(@Param("username") String username);

    List<User> selectUserByUserMobile(@Param("mobile") String mobile);

    List<User> selectUserByUserUserAndMobile(@Param("username") String username,@Param("mobile") String mobile);
}