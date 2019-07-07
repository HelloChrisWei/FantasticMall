package com.cskaoyan.mapper;

import com.cskaoyan.bean.Role;
import com.cskaoyan.bean.RoleExample;
import com.cskaoyan.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectRole();

    List<Role> selectRoleByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<Role> selectRoleByName(@Param("name") String name);

}
