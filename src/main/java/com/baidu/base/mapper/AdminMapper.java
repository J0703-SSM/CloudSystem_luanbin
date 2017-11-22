package com.baidu.base.mapper;

import com.baidu.base.domain.Admin_info;

/**
 * Created by dllo on 2017/11/13.
 */
public interface AdminMapper {

    Admin_info login(Admin_info admin_info);

    Admin_info selectById(int id);
}
