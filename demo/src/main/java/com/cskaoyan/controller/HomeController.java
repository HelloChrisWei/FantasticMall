package com.cskaoyan.controller;

import com.cskaoyan.vo.SingleReadVO;
import com.cskaoyan.vo.SysReadVO;
import com.cskaoyan.vo.SysResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/auth/login")
    @ResponseBody
    public SingleReadVO login() {
        SingleReadVO<Object> readVO = new SingleReadVO<>();
        readVO.setData("c3818fc8-8d14-4aca-925d-fea28cfc4522");
        readVO.setErrmsg("成功");
        readVO.setErrno(0);
        return readVO;
    }

    @RequestMapping("/auth/info")
    @ResponseBody
    public SysReadVO info() {
        SysReadVO readVO = new SysReadVO();
        SysResultVO resultVO = new SysResultVO();

        resultVO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        resultVO.setName("admin123");

        List<String> perms = new ArrayList<>();
        perms.add("*");
        resultVO.setPerms(perms);

        List<String> roles = new ArrayList<>();
        roles.add("超级管理员");
        resultVO.setRoles(roles);

        readVO.setData(resultVO);
        readVO.setErrmsg("成功");
        readVO.setErrno(0);

        return readVO;

    }

}
