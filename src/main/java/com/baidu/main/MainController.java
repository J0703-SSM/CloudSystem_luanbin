package com.baidu.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 2017/11/11.
 */
@Controller
public class MainController {


    @RequestMapping("/role_list")
    public String roleList(){
        return "role/role_list";
    }

    @RequestMapping("/admin_list")
    public String adminList(){
        return "admin/admin_list";
    }

    @RequestMapping("/fee_list")
    public String feeList(){
        return "fee/fee_list";
    }

    @RequestMapping("/account_list")
    public String accountList(){
        return "account/account_list";
    }

    @RequestMapping("/service_list")
    public String serviceList(){
        return "fee/fee_list";
    }


    @RequestMapping("/bill_list")
    public String billList(){
        return "bill/bill_list";
    }

    @RequestMapping("/report_list")
    public String reportList(){
        return "report/report_list";
    }

    @RequestMapping("/user_info")
    public String userList(){
        return "user/user_info";
    }




    @RequestMapping("/admin/admin_add")
    public String admin_add(){
        return "admin/admin_add";
    }


}
