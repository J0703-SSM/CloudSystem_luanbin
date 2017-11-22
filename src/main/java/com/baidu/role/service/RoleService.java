package com.baidu.role.service;

import com.baidu.base.domain.Admin_info;
import com.baidu.base.domain.ModuleInfo;
import com.baidu.base.domain.RoleInfo;
import com.baidu.base.domain.RoleModule;
import com.baidu.base.domain.ext.ExtAdmin;
import com.baidu.base.domain.ext.ExtRole;

import javax.management.relation.Role;
import java.util.List;

/**
 * Created by dllo on 2017/11/14.
 */
public interface RoleService {
//    List<ExtAdmin> selectModule();

    List<ExtRole> selectRoleAll();

    List<ModuleInfo> selectModuleAll();

    int insert(RoleInfo record);

    int insertModule(String name);

    RoleInfo selectRoleByName(String name);

    ModuleInfo selectModuleByName(String name);

    int insertRM(RoleModule roleModule);

    int deleteByPrimaryKey(Integer roleId);

    int deleteModule_id(int role_id);

    ExtRole selectRoleByRoleId(int role_id);
}
