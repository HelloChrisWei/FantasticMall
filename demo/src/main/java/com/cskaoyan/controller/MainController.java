package com.cskaoyan.controller;

import com.cskaoyan.service.MainService;
import com.cskaoyan.util.ReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping("/dashboard")
    @ResponseBody
    public ReadVO dashboard() {
        return mainService.readStatic();
    }

}
