package com.cskaoyan.controller.ad;

import com.cskaoyan.bean.Storage;
import com.cskaoyan.service.ad.StorageService;
import com.cskaoyan.utils.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 
 * @version 1.0 2019/7/4
 * @author Wei
 */
@RestController
@RequestMapping("/storage")
public class AdminStorageController {
    // Logging
    private final Logger logger = Logger.getLogger(AdminStorageController.class);

    @Autowired
    private StorageService storageService;

    @PostMapping("/create")
    public Object create(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();

        Storage storage = storageService.store(file.getInputStream(), file.getSize(),
                file.getContentType(), originalFilename);

        return ResponseUtil.ok(storage);
    }
}
