package com.cskaoyan.mapper;

import com.cskaoyan.bean.Category;
import com.cskaoyan.bean.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CategoryMapper {
    List<Category> getL1();

    List<Category> getL2(Integer id);

    int updateL2Pid(@Param("id") Integer id,@Param("pid") Integer pid);

    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    Category selectIdsById(Integer id);

    List<Category> selectCategoryList(Integer id);
}