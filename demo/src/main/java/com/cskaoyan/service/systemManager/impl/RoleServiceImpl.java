package com.cskaoyan.service.systemManager.impl;

import com.cskaoyan.bean.Role;
import com.cskaoyan.mapper.RoleMapper;
import com.cskaoyan.service.systemManager.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean createRole(Role role) {
        List<Role> roles = roleMapper.selectRoleByName(role.getName());
        if (roles.size() == 0) {
            roleMapper.insertSelective(role);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateRole(Role role) {
        int isUpdate = roleMapper.updateByPrimaryKeySelective(role);
        return isUpdate > 0;
    }

    @Override
    public boolean deleteRole(Role role) {
        int isDelete = roleMapper.deleteByPrimaryKey(role.getId());
        return isDelete > 0;
    }

    @Override
    public List<Role> readRole() {
        return roleMapper.selectRole();
    }

    @Override
    public List<Role> readRoleByPage(int limit, int offset) {
        return roleMapper.selectRoleByPage(limit, offset);
    }

    @Override
    public List<Role> readRoleByName(String name) {
        return roleMapper.selectRoleByName(name);
    }
}
