package com.baidu.admin.service.impl;

import com.baidu.admin.dao.AdminDao;
import com.baidu.base.domain.Admin_info;
import com.baidu.base.domain.ext.ExtAdmin;
import com.baidu.base.mapper.AdminMapper;
import com.baidu.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 2017/11/13.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Qualifier("adminDao")
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin_info login(Admin_info admin_info) {
        return adminDao.login(admin_info);
    }

    @Override
    public Admin_info selectById(int id) {
        return adminDao.selectById(id);
    }

    @Override
    public List<ExtAdmin> selectAdminAll() {
        return adminDao.selectAdminAll();
    }

    @Override
    public ExtAdmin selectAdminById(int id) {
        return adminDao.selectAdminById(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin_info admin_info) {
        return adminDao.updateByPrimaryKeySelective(admin_info);
    }

}
