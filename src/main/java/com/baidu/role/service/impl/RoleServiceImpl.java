package com.baidu.role.service.impl;

import com.baidu.base.domain.Admin_info;
import com.baidu.base.domain.ModuleInfo;
import com.baidu.base.domain.RoleInfo;
import com.baidu.base.domain.RoleModule;
import com.baidu.base.domain.ext.ExtAdmin;
import com.baidu.base.domain.ext.ExtRole;
import com.baidu.base.mapper.RoleInfoMapper;
import com.baidu.role.dao.RoleDao;
import com.baidu.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 2017/11/14.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Qualifier("roleDao")
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<ExtRole> selectRoleAll() {
        return roleDao.selectRoleAll();
    }

    @Override
    public List<ModuleInfo> selectModuleAll() {
        return roleDao.selectModuleAll();
    }

    @Override
    public int insert(RoleInfo record) {
        return roleDao.insert(record);
    }

    @Override
    public int insertModule(String name) {
        return roleDao.insertModule(name);
    }

    @Override
    public RoleInfo selectRoleByName(String name) {
        return roleDao.selectRoleByName(name);
    }


    @Override
    public ModuleInfo selectModuleByName(String name) {
        return roleDao.selectModuleByName(name);
    }

    @Override
    public int insertRM(RoleModule roleModule) {
        return roleDao.insertRM(roleModule);
    }

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return roleDao.deleteByPrimaryKey(roleId);
    }

    @Override
    public int deleteModule_id(int role_id) {
        return roleDao.deleteModule_id(role_id);
    }

    @Override
    public ExtRole selectRoleByRoleId(int role_id) {
        return roleDao.selectRoleByRoleId(role_id);
    }

//    @Override
//    public List<ExtAdmin> selectModule() {
//        return roleDao.selectModule();
//    }
}
