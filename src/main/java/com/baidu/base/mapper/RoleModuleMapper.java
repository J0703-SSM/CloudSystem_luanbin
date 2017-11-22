package com.baidu.base.mapper;

import com.baidu.base.domain.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}