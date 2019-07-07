package com.cskaoyan.service.systemManager.impl;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.mapper.AdminMapper;
import com.cskaoyan.service.systemManager.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean createAdmin(Admin admin) {
        List<Admin> admins = adminMapper.selectAdminByUserName(admin.getUsername());
        if (admins.size() == 0) {
            admin.setAddTime(new Date());
            admin.setUpdateTime(new Date());
            adminMapper.insertSelective(admin);
            return true;
        } else
            return false;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        admin.setUpdateTime(new Date());
        int isUpdate = adminMapper.updateByPrimaryKeySelective(admin);
        return isUpdate > 0;
    }

    @Override
    public boolean deleteAdmin(Admin admin) {
        int isDelete = adminMapper.deleteByPrimaryKey(admin.getId());
        return isDelete > 0;
    }

    @Override
    public List<Admin> readAdminByPage(int limit, int offset) {
        List<Admin> admins = adminMapper.selectAdminByPage(limit, offset);
        return admins;
    }

    @Override
    public List<Admin> readAdminByUserName(String username) {
        List<Admin> admins = adminMapper.selectAdminByUserName(username);
        return admins;
    }
}
