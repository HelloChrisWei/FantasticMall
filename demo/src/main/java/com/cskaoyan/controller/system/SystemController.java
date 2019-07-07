package com.cskaoyan.controller.system;

import com.cskaoyan.bean.MallSystem;
import com.cskaoyan.service.system.SystemService;

import com.cskaoyan.vo.SingleReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/config")
/*@RequestMapping("/admin/config")*/
public class SystemController {
    @Autowired
    SystemService service;

    @GetMapping("/mall")

    public SingleReadVO<Object> findMall(){return basic("cskaoyan_mall_mall");}

    @PostMapping("/mall")

    public SingleReadVO<Object> updateMall(@RequestBody Map<String,String> map){
        return basicUpdate(map);}


    @GetMapping("/express")
    public SingleReadVO<Object> findExpress(){return basic("cskaoyan_mall_express");}

    @PostMapping("/express")
    public SingleReadVO<Object> updateExpress(@RequestBody Map<String,String> map){return basicUpdate(map);}

    @GetMapping("/order")

    public SingleReadVO<Object> findOrder(){return basic("cskaoyan_mall_order");}

    @PostMapping("/order")

    public SingleReadVO<Object> updateOrder(@RequestBody Map<String,String> map){
        return basicUpdate(map);}

    @GetMapping("/wx")

    public SingleReadVO<Object> findWx(){return basic("cskaoyan_mall_wx");}

    @PostMapping("/wx")

    public SingleReadVO<Object> updateWx(@RequestBody Map<String,String> map){
        return basicUpdate(map);}


    private SingleReadVO<Object> basic(String prefix) {
        HashMap<String,String> map = new HashMap<>();
        List<MallSystem> mallSystems = service.selectMallSystemByPrefix(prefix);

        for (MallSystem system:mallSystems) {
            map.put(system.getKeyName(),system.getKeyValue());
        }
        SingleReadVO<Object> singleReadVO = new SingleReadVO<>();
        singleReadVO.setData(map);
        singleReadVO.setErrno(0);
        singleReadVO.setErrmsg("成功");
        return singleReadVO;
    }

    private SingleReadVO<Object> basicUpdate(Map<String,String> map) {
        SingleReadVO<Object> singleReadVO = new SingleReadVO<>();
        boolean update = service.updateMallSystem(map);
        if (update == true){
            singleReadVO.setErrmsg("修改成功");
            singleReadVO.setErrno(0);
            return singleReadVO;
        }else{
            singleReadVO.setErrno(500);
            singleReadVO.setErrmsg("修改失败");
            return singleReadVO;
        }

    }

}
