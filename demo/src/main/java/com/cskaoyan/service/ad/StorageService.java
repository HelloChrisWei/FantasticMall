package com.cskaoyan.service.ad;

import com.cskaoyan.bean.Storage;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * 
 * @version 1.0 2019/7/4
 * @author Wei
 */
@Service
public class StorageService {
    private Storage storage;

    public Storage store(InputStream inputStream, long size, String contentType, String originalFilename) {
        return null;
    }



//    private String generateKey(String originalFilename) {
//        int index = originalFilename.lastIndexOf('.');
//        String suffix = originalFilename.substring(index);
//
//        String key = null;
//        Storage storageInfo = null;
//
//        do {
//            key = CharUtil.getRandomString(20) + suffix;
//            storageInfo = litemallStorageService.findByKey(key);
//        }
//        while (storageInfo != null);
//
//        return key;
//    }
}
