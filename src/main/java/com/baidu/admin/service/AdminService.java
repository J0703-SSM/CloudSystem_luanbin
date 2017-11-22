package com.baidu.admin.service;

import com.baidu.base.domain.Admin_info;
import com.baidu.base.domain.ext.ExtAdmin;

import java.util.List;

/**
 * Created by dllo on 2017/11/13.
 */
public interface AdminService {
    Admin_info login(Admin_info admin_info);

    Admin_info selectById(int id);

    List<ExtAdmin> selectAdminAll();

    ExtAdmin selectAdminById(int id);

    int updateByPrimaryKeySelective(Admin_info admin_info);
}
