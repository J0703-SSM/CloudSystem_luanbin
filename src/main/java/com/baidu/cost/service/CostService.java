package com.baidu.cost.service;

import com.baidu.base.domain.Cost;
import com.baidu.base.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 2017/11/11.
 */
public interface CostService {

    List<Cost> findCostAll();

    int insert(Cost record);

    int startStatus(Cost cost);

    int deleteByPrimaryKey(Integer id);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);
    PageBean<Cost> findCostAllLimit(int pc, int ps);
}
