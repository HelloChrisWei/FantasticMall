package com.cskaoyan.service.systemManager;

import com.cskaoyan.bean.Role;

import java.util.List;

public interface RoleService {

    boolean createRole(Role role);

    boolean updateRole(Role role);

    boolean deleteRole(Role role);

    List<Role> readRole();

    List<Role> readRoleByPage(int limit, int offset);

    List<Role> readRoleByName(String name);

}
