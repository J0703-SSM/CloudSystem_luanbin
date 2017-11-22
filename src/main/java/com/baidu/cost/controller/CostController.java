package com.baidu.cost.controller;

import com.baidu.base.domain.Cost;
import com.baidu.cost.service.CostService;
import com.baidu.base.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dllo on 2017/11/10.
 */
@RequestMapping("/fee")
@Controller
public class CostController {

    @Qualifier("costService")
    @Autowired
    private CostService costService;
    private int pageCode;

    @RequestMapping(value = "/fee_list_findAll/{pc}")
    public String fee_list_findAll( @PathVariable String pc, Model model) {
        if (pc == null || pc.trim().isEmpty()) {
            pageCode = 1;
        }else {
            pageCode = Integer.parseInt(pc);
        }
        // 指定每页记录数
        int ps = 4;
        // 传递 pc ,ps 获得 pageBean
        PageBean<Cost> pb = costService.findCostAllLimit(pageCode, ps);
        model.addAttribute("pb", pb);
        return "fee/fee_list";
    }

    @RequestMapping("/fee_add")
    public String fee_add(){
        return "fee/fee_add";
    }

    @RequestMapping(value = "/addCost")
    public String addCost(Cost cost) throws ParseException {
        System.out.println(cost);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = sdf.parse(sdf.format(new Date()));
        cost.setCreatime(time);
        cost.setStatus("1");
        t1(cost);
        costService.insert(cost);
        return "forward:/fee/fee_list_findAll/1";
    }

    @RequestMapping(value = "/startStatus")
    public void startStatus(Integer id, Cost cost) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = sdf.parse(sdf.format(new Date()));
        cost.setId(id);
        cost.setStartime(time);
        costService.startStatus(cost);
    }


    @RequestMapping(value = "/deleteCost")
    public void deleteCost(Integer id) {
        costService.deleteByPrimaryKey(id);
    }

    @RequestMapping("/fee_detail/{id}")
    public String fee_detail(@PathVariable Integer id, Model model) {
        Cost cost = costService.selectByPrimaryKey(id);
        model.addAttribute("cost", cost);
        return "fee/fee_detail";
    }

    @RequestMapping("/fee_modi/{id}")
    public String fee_modi(@PathVariable Integer id, Model model) {
        Cost cost = costService.selectByPrimaryKey(id);
        model.addAttribute("cost", cost);
        return "fee/fee_modi";
    }

    @RequestMapping("/updateCost")
    public String updateCost(Cost cost){
        System.out.println(cost);
        t1(cost);
        costService.updateByPrimaryKeySelective(cost);
        return "forward:/fee/fee_list_findAll/1";
    }

    private void t1(Cost cost){
        // 1.包月 2.套餐 3.计时
        if (cost.getUnit_cost() ==null){
            cost.setCost_type("1");
        }else if (cost.getBase_duration() ==null){
            cost.setCost_type("2");
        }else {
            cost.setCost_type("3");
        }
    }
}
