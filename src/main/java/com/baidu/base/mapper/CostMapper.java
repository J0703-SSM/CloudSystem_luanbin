package com.baidu.base.mapper;

import com.baidu.base.domain.Cost;
import com.baidu.base.utils.PageBean;

import java.util.List;

public interface CostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Cost> findCostAll();

    int startStatus(Cost cost);

    List<Cost> findCostAllLimit(PageBean<Cost> pageBean);

}