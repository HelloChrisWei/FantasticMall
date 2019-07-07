package com.cskaoyan.controller;

import com.cskaoyan.bean.Data;
import com.cskaoyan.bean.ResponseVO;
import com.cskaoyan.bean.ResponseVOO;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.service.systemManager.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO list(int page, int limit, String key, String name) {
        int offset = (page - 1) * limit;
        if (key == null && name == null) {
            List<Storage> storages = storageService.selectStorageByPage(limit, offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null ? 0 : storages.size());
            storageData.setItems(storages);
            return new ResponseVO(storageData, "成功", 0);
        } else if (key != null && name == null) {
            List<Storage> storages = storageService.selectStorageByKey(key, limit, offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null ? 0 : storages.size());
            storageData.setItems(storages);
            return new ResponseVO(storageData, "成功", 0);
        } else if (key == null && name != null) {
            List<Storage> storages = storageService.selectStorageByName(name, limit, offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null ? 0 : storages.size());
            storageData.setItems(storages);
            return new ResponseVO(storageData, "成功", 0);
        } else {
            List<Storage> storages = storageService.selectStorageByKeyAndName(key, name, limit, offset);
            Data<Storage> storageData = new Data<>();
            storageData.setTotal(storages == null ? 0 : storages.size());
            storageData.setItems(storages);
            return new ResponseVO(storageData, "成功", 0);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseVOO update(@RequestBody Storage storage) {
        boolean flag = storageService.updateStorage(storage);
        if (flag) {
            return new ResponseVOO(storage, "成功", 0);
        } else {
            return null;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseVOO delete(@RequestBody Storage storage) {
        boolean flag = storageService.deleteStorage(storage);
        if (flag) {
            return new ResponseVOO(null, "成功", 0);
        } else {
            return null;
        }
    }
}
