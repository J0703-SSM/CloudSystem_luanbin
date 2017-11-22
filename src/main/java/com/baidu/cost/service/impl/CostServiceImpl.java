package com.baidu.cost.service.impl;

import com.baidu.base.domain.Cost;
import com.baidu.base.mapper.CostMapper;
import com.baidu.cost.service.CostService;
import com.baidu.base.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 2017/11/11.
 */
@Service("costService")
public class CostServiceImpl implements CostService {

    @Qualifier("costDao")
    @Autowired
    private CostMapper costMapper;

    @Override
    public List<Cost> findCostAll() {
        return costMapper.findCostAll();
    }

    @Override
    public int insert(Cost record) {
        return costMapper.insert(record);
    }

    @Override
    public int startStatus(Cost cost) {
        return costMapper.startStatus(cost);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return costMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Cost selectByPrimaryKey(Integer id) {
        return costMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cost record) {
        return costMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean<Cost> findCostAllLimit(int pc, int ps) {
        /**
         * 1. 创建一个 pageBean 对象, pb
         * 2. 设置 pb 的 pc 和 ps
         * 3. 得到 tr, 设置给 pb
         * 4. 得到 beanList, 设置给 pb
         * 5. 返回 pb
         */
        PageBean<Cost> pb = new PageBean<>();
        pb.setPageCode(pc);
        pb.setPageSize(ps);
        pb.setUrl("/fee/fee_list_findAll");

        // 得到 tr 总记录数
        List<Cost> costAll = costMapper.findCostAll();
        int tr = costAll.size();
        pb.setTotalRecord(tr);

        pb.setStart((pc - 1) * ps);
        // 得到 BeanList, 10条数据 pc是变化得, limit 起始行 总行数
        List<Cost> costAllLimit = costMapper.findCostAllLimit(pb);
        /**
         * pc : 1 0-9
         * pc : 2 10-19
         * pc : 3 20-29
         */
        pb.setBeanList(costAllLimit);
        return pb;
    }

}
