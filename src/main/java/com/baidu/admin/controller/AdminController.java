package com.baidu.admin.controller;

import com.baidu.base.domain.Admin_info;
import com.baidu.admin.service.AdminService;
import com.baidu.base.domain.ext.ExtAdmin;
import com.baidu.base.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 2017/11/13.
 */
@Controller
public class AdminController {


    @Qualifier("adminService")
    @Autowired
    private AdminService adminService;


    private String text;

    @RequestMapping(value = "/login")
    public String login(@Validated Admin_info admin_info, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (result.hasErrors()) {
            FieldError admin_code = result.getFieldError("admin_code");
            FieldError password = result.getFieldError("password");
            //将输入验证的错误信息回显到登录页面
            model.addAttribute("admin_codeError", admin_code);
            model.addAttribute("passwordError", password);
        }
        if (!admin_info.getCode().equalsIgnoreCase(text)) {
            model.addAttribute("codeError", "验证码输入不正确");
            return "login";
        }
        Admin_info login = adminService.login(admin_info);
        if (login != null) {
            request.getServletContext().setAttribute("login", login);
            return "index";
        }
        model.addAttribute("loginError", "登录失败, 用户名或者密码不存在");
        System.out.println(model);
        return "login";
    }


    @RequestMapping(value = "/getVerifyCode")
    public void getVerifyCode(HttpServletResponse response) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        text = vc.getText();
        VerifyCode.output(image, response.getOutputStream());
    }

    @RequestMapping("/admin/admin_list_findAll")
    public String admin_list_findAll(Model model) {
        List<ExtAdmin> extAdmins = adminService.selectAdminAll();
        for (ExtAdmin extAdmin : extAdmins) {
            if (extAdmin.getRole_names() != null) {
                List<String> results = Arrays.asList(extAdmin.getRole_names().split(","));
                extAdmin.setStrings(results);
            }
        }
        model.addAttribute("extAdmins", extAdmins);
        return "admin/admin_list";
    }


    @RequestMapping(value = "/user_info_select")
    public String user_info_select(HttpServletRequest request, Model model) {
        Admin_info login = (Admin_info) request.getServletContext().getAttribute("login");
        ExtAdmin extAdmin = adminService.selectAdminById(login.getId());
        model.addAttribute("extAdmin", extAdmin);
        return "user/user_info";
    }

    @RequestMapping("/user_info_update")
    public String user_info_update(@Validated Admin_info admin_info, BindingResult br, Model model) {
        if (br.hasErrors()) {
            FieldError name = br.getFieldError("name");
//            FieldError telephone = br.getFieldError("telephone");
//            FieldError email = br.getFieldError("email");
            model.addAttribute("nameError", name);
//            model.addAttribute("telephoneError", telephone);
//            model.addAttribute("emailError", email);
            return "forward:/user_info_select";
        }
        adminService.updateByPrimaryKeySelective(admin_info);
        return "forward:/user_info_select";
    }

    @RequestMapping("/user_modi_pwd")
    public String user_modi_pwd() {
        return "user/user_modi_pwd";
    }

    @RequestMapping("/update_password")
    public String update_password(String oldPassword, String newPassword, String rePassword, HttpServletRequest request, Model model) {
        System.out.println(oldPassword);
        Admin_info login = (Admin_info) request.getServletContext().getAttribute("login");
        if (!login.getPassword().equals(oldPassword)) {
            model.addAttribute("oldPasswordError", "旧密码输入不正确");
            return "user/user_modi_pwd";
        }
        if ("".equals(newPassword) || newPassword == null) {
            model.addAttribute("newPasswordError", "新密码不能为空");
            return "user/user_modi_pwd";
        }
        if(newPassword.equals(oldPassword)){
            model.addAttribute("newPasswordError", "新旧密码不能一致");
            return "user/user_modi_pwd";
        }
        if ("".equals(rePassword) || rePassword == null) {
            model.addAttribute("rePasswordError", "确认密码不能为空");
            return "user/user_modi_pwd";
        }
        if (!newPassword.equals(rePassword)) {
            model.addAttribute("rePasswordError", "两次密码不一致");
            return "user/user_modi_pwd";
        }

        login.setPassword(newPassword);
        adminService.updateByPrimaryKeySelective(login);
        request.getServletContext().setAttribute("login",null);
        return "/login";
    }

}
