package com.cskaoyan.service.systemManager;

import com.cskaoyan.bean.Storage;

import java.util.List;

public interface StorageService {

    // boolean createStorage(Storage storage);

    boolean updateStorage(Storage storage);

    boolean deleteStorage(Storage storage);

    List<Storage> selectStorageByPage(int limit, int offset);

    List<Storage> selectStorageByKey(String key, int limit, int offset);

    List<Storage> selectStorageByName(String name, int limit, int offset);

    List<Storage> selectStorageByKeyAndName(String key, String name, int limit, int offset);


}
