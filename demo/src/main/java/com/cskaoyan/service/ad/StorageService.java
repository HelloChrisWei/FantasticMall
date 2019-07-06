package com.cskaoyan.service.ad;

import com.aliyun.oss.OSSClient;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.config.AliyunConfig;
import com.cskaoyan.mapper.StorageMapper;
import com.cskaoyan.utils.ResponseUtil;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理图片上传
 * @version 1.0 2019/7/4
 * @author Wei
 */
@Service
public class StorageService {

    @Resource
    private StorageMapper storageMapper;

    // 允许上传的图片格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",
            ".jpeg", ".gif", ".png"};

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private AliyunConfig aliyunConfig;


    public Object store(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();

        String filePath = getFilePath(originalFilename);

        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(originalFilename, type)) {
                isLegal = true;
                break;
            }
        }

        if (!isLegal) {
            return ResponseUtil.badArgument();
        }

        // 上传到阿里云
        try {
            // 目录结构: images/2019/07/05/xxxx.jpg
            ossClient.putObject(aliyunConfig.getBucketName(), filePath,
                    new ByteArrayInputStream(file.getBytes()));
        } catch (Exception e) {
            // 上传失败
            e.printStackTrace();
            return ResponseUtil.badArgument();
        }


        // 上传成功
        Storage storage = new Storage();
        String url = aliyunConfig.getUrlPrefix() + filePath;

        storage.setName(originalFilename);
        storage.setSize((int) file.getSize());
        storage.setType(file.getContentType());
        storage.setKey(generateKey(file));
        storage.setUrl(url);
        // 传入new Date()精确到毫秒造成SQL语句错误
//        storage.setAddTime(new LocalDateTime().toDate());
//        storage.setUpdateTime(new LocalDateTime().toDate());

        storageMapper.insertSelective(storage);


        return ResponseUtil.ok(storage);



        /*String key = generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);

        String url = generateUrl(key);
        LitemallStorage storageInfo = new LitemallStorage();
        storageInfo.setName(fileName);
        storageInfo.setSize((int) contentLength);
        storageInfo.setType(contentType);
        storageInfo.setKey(key);
        storageInfo.setUrl(url);
        litemallStorageService.add(storageInfo);

        return storageInfo;*/

    }


    // 使用MD5生成key
    private String generateKey(MultipartFile file) {
//        int index = originalFilename.lastIndexOf('.');
//        // suffix of file
//        String suffix = originalFilename.substring(index);
//
//        String key = null;
//        LitemallStorage storageInfo = null;
//
//        do {
//            key = CharUtil.getRandomString(20) + suffix;
//            storageInfo = litemallStorageService.findByKey(key);
//        }
//        while (storageInfo != null);

        // 获取Spring提供的MD5算法类计算MD5值
        String key = null;
        try {
            key = DigestUtils.md5DigestAsHex(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return key;
    }



    private String getFilePath (String originalFilename){
        DateTime dateTime = new DateTime();
        return "images/" + dateTime.toString("yyyy")
                + "/" + dateTime.toString("MM")
                + "/" + dateTime.toString("dd")
                + "/" + System.currentTimeMillis() + "-" + originalFilename;
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
