package com.cskaoyan.service.systemManager.impl;

import com.cskaoyan.bean.Storage;
import com.cskaoyan.mapper.StorageMapper;
import com.cskaoyan.service.systemManager.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public boolean updateStorage(Storage storage) {
        int isUpdate = storageMapper.updateByPrimaryKeySelective(storage);
        return isUpdate == 1;
    }

    @Override
    public boolean deleteStorage(Storage storage) {
        int isDelete = storageMapper.deleteByPrimaryKey(storage.getId());
        return isDelete == 1;
    }

    @Override
    public List<Storage> selectStorageByPage(int limit, int offset) {
        return storageMapper.selectStorageByPage(limit, offset);
    }

    @Override
    public List<Storage> selectStorageByKey(String key, int limit, int offset) {
        return storageMapper.selectStorageByKey(key, limit, offset);
    }

    @Override
    public List<Storage> selectStorageByName(String name, int limit, int offset) {
        return storageMapper.selectStorageByName(name, limit, offset);
    }

    @Override
    public List<Storage> selectStorageByKeyAndName(String key, String name, int limit, int offset) {
        return storageMapper.selectStorageByKeyAndName(key, name, limit, offset);
    }
}
