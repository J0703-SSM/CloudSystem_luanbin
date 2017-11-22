package com.baidu.role.dao;

import com.baidu.base.domain.Admin_info;
import com.baidu.base.domain.ModuleInfo;
import com.baidu.base.domain.RoleInfo;
import com.baidu.base.domain.RoleModule;
import com.baidu.base.domain.ext.ExtAdmin;
import com.baidu.base.domain.ext.ExtRole;
import com.baidu.base.mapper.RoleInfoMapper;

import javax.management.relation.Role;
import java.util.List;

/**
 * Created by dllo on 2017/11/14.
 */
public interface RoleDao extends RoleInfoMapper{
//    List<ExtAdmin> selectModule();

    List<ExtRole> selectRoleAll();

    List<ModuleInfo> selectModuleAll();

    int insertModule(String name);

    RoleInfo selectRoleByName(String name);

    ModuleInfo selectModuleByName(String name);

    int insertRM(RoleModule roleModule);

    int deleteModule_id(int role_id);

    ExtRole selectRoleByRoleId(int role_id);
}
