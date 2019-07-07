package com.cskaoyan.mapper;

import com.cskaoyan.bean.Storage;
import com.cskaoyan.bean.StorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageMapper {
    long countByExample(StorageExample example);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    List<Storage> selectStorageByPage(@Param("limit") int limit, @Param("offset") int offset);

    List<Storage> selectStorageByKey(@Param("key") String key, @Param("limit") int limit, @Param("offset") int offset);

    List<Storage> selectStorageByName(@Param("name") String name, @Param("limit") int limit, @Param("offset") int offset);

    List<Storage> selectStorageByKeyAndName(@Param("key") String key, @Param("name") String name, @Param("limit") int limit, @Param("offset") int offset);

}