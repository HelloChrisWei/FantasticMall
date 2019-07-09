package com.cskaoyan.controller.userInformation;

import com.cskaoyan.bean.User;
import com.cskaoyan.service.userInformaitonService.UserService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.SingleReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/list")

    @ResponseBody
    public ReadVO selectUserByUsername(int page,int limit,String username,String mobile){
        return userService.selectUser(page, limit, username,mobile);
    }
}
