package com.cskaoyan.service.systemManager;

import com.cskaoyan.bean.Admin;

import java.util.List;

public interface AdminService {

    boolean createAdmin(Admin admin);

    boolean updateAdmin(Admin admin);

    boolean deleteAdmin(Admin admin);

    List<Admin> readAdminByPage(int limit, int offset);

    List<Admin> readAdminByUserName(String username);

}
