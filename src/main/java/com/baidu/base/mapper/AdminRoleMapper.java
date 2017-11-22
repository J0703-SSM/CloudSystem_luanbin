package com.baidu.base.mapper;

import com.baidu.base.domain.AdminRole;

public interface AdminRoleMapper {
    int insert(AdminRole record);

    int insertSelective(AdminRole record);
}