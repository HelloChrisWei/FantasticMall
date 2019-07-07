package com.cskaoyan.controller;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Data;
import com.cskaoyan.bean.ResponseVO;
import com.cskaoyan.bean.ResponseVOO;
import com.cskaoyan.service.systemManager.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO list(int page, int limit, String username) {
        if (username == null) {
            int offset = (page - 1) * limit;
            List<Admin> admins = adminService.readAdminByPage(limit, offset);
            Data<Admin> adminData = new Data<>();
            adminData.setItems(admins);
            adminData.setTotal(admins == null ? 0 : admins.size());
            return new ResponseVO(adminData, "成功", 0);
        } else {
            List<Admin> admins = adminService.readAdminByUserName(username);
            Data<Admin> adminData = new Data<>();
            adminData.setItems(admins);
            adminData.setTotal(admins == null ? 0 : admins.size());
            return new ResponseVO(adminData, "成功", 0);
        }
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResponseVOO create(@RequestBody Admin admin) {
        if (admin.getPassword().length() < 6) {
            return new ResponseVOO(null, "管理员密码长度不能小于6", 601);
        } else if (admin.getUsername().length() < 6) {
            return new ResponseVOO(null, "管理员名称不符合规定", 601);
        }
        boolean isAdd = adminService.createAdmin(admin);
        if (isAdd) {
            return new ResponseVOO(admin, "成功", 0);
        } else {
            return new ResponseVOO(null, "管理员已经存在", 602);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseVOO update(@RequestBody Admin admin) {
        if (admin.getPassword().length() < 6) {
            return new ResponseVOO(null, "管理员密码长度不能小于6", 602);
        } else if (admin.getUsername().length() < 6) {
            return new ResponseVOO(null, "管理员名称不符合规定", 601);
        }
        boolean flag = adminService.updateAdmin(admin);
        if (flag) {
            return new ResponseVOO(admin, "成功", 0);
        } else {
            return null;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseVOO delete(@RequestBody Admin admin) {
        boolean flag = adminService.deleteAdmin(admin);
        if (flag) {
            return new ResponseVOO(null, "成功", 0);
        } else {
            return null;
        }
    }
}
