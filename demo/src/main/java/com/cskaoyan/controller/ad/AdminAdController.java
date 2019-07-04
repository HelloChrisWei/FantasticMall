package com.cskaoyan.controller.ad;


import com.cskaoyan.bean.Ad;
import com.cskaoyan.service.ad.LitemallAdService;
import com.cskaoyan.utils.ResponseUtil;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 * @version 1.0 2019/7/4
 * @author Wei
 */
@RestController
@RequestMapping("/ad")
public class AdminAdController {
    // Logging
    private final Logger logger = Logger.getLogger(AdminAdController.class);

    @Autowired
    private LitemallAdService adService;


    @GetMapping("/list")
    public Object list(String name, String content,
                  @RequestParam Integer page,
                  @RequestParam Integer limit,
                  @RequestParam String sort,
                  @RequestParam String order) {
        List<Ad> adList = adService.querySelective(name, content, page, limit, sort, order);

        return ResponseUtil.okList(adList);
    }


    @PostMapping("/delete")
    public Object delete(@RequestBody Ad ad) {
        Integer id = ad.getId();
        if (id == null) {
            return ResponseUtil.badArgument();
        }
        adService.deleteById(id);
        return ResponseUtil.ok();
    }


    // FIXME 前台显示时间为毫秒数不是日期格式
    @PostMapping("/update")
    public Object update(@RequestBody Ad ad) {
        Object error = validate(ad);
        if (error != null) {
            return error;
        }
        if (adService.updateById(ad) == 0) {
            return ResponseUtil.updatedDataFailed();
        }

        return ResponseUtil.ok(ad);

    }




    /**
     * 验证对象是否合法
     * @param ad 传入的对象
     * @return
     */
    private Object validate(Ad ad) {
        String name = ad.getName();
        if (StringUtils.isEmpty(name)) {
            return ResponseUtil.badArgument();
        }
        String content = ad.getContent();
        if (StringUtils.isEmpty(content)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

}
