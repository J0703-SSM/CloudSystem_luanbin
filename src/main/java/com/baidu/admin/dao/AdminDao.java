package com.baidu.admin.dao;

import com.baidu.base.domain.Admin_info;
import com.baidu.base.domain.ext.ExtAdmin;
import com.baidu.base.mapper.AdminMapper;

import java.util.List;

/**
 * Created by dllo on 2017/11/14.
 */
public interface AdminDao extends AdminMapper{
    List<ExtAdmin> selectAdminAll();

    ExtAdmin selectAdminById(int id);

    int updateByPrimaryKeySelective(Admin_info admin_info);
}
