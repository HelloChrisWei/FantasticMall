package com.cskaoyan.controller;

import com.cskaoyan.bean.Data;
import com.cskaoyan.bean.ResponseVO;
import com.cskaoyan.bean.ResponseVOO;
import com.cskaoyan.bean.Role;
import com.cskaoyan.service.systemManager.RoleService;
import com.cskaoyan.util.SingleReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/options")
    @ResponseBody
    public SingleReadVO<List<HashMap>> options() {
        List<Role> roles = roleService.readRole();

        List<HashMap> data = new ArrayList<>();
        for (Role role : roles) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("label", role.getName());
            map.put("value", role.getId());
            data.add(map);
        }
        return new SingleReadVO<>(data, "成功", 0);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResponseVO list(int page, int limit, String name) {
        if (name == null) {
            int offset = (page - 1) * limit;
            List<Role> roles = roleService.readRoleByPage(limit, offset);
            Data<Role> roleData = new Data<>();
            roleData.setItems(roles);
            roleData.setTotal(roles == null ? 0 : roles.size());
            return new ResponseVO(roleData, "成功", 0);
        } else {
            List<Role> roles = roleService.readRoleByName(name);
            Data<Role> roleData = new Data<>();
            roleData.setItems(roles);
            roleData.setTotal(roles == null ? 0 : roles.size());
            return new ResponseVO(roleData, "成功", 0);
        }
    }

    @RequestMapping("/create")
    @ResponseBody
    public ResponseVOO create(@RequestBody Role role) {
        boolean flag = roleService.createRole(role);
        if (flag) {
            return new ResponseVOO(role, "成功", 0);
        } else {
            return new ResponseVOO(null, "角色已经存在", 640);
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseVOO update(@RequestBody Role role) {
        boolean flag = roleService.updateRole(role);
        if (flag) {
            return new ResponseVOO(role, "成功", 0);
        } else {
            return null;
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseVOO delete(@RequestBody Role role) {
        boolean flag = roleService.deleteRole(role);
        if (flag) {
            return new ResponseVOO(null, "成功", 0);
        } else {
            return null;
        }
    }
}
