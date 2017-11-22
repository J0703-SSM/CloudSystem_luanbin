package com.baidu.role.controller;

import com.baidu.base.domain.ModuleInfo;
import com.baidu.base.domain.RoleInfo;
import com.baidu.base.domain.RoleModule;
import com.baidu.base.domain.ext.ExtRole;
import com.baidu.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 2017/11/14.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Qualifier("roleService")
    @Autowired
    private RoleService roleService;

    @RequestMapping("/role_list_findAll")
    public String role_list_findAll(Model model) {
        List<ExtRole> extRoles = roleService.selectRoleAll();
        model.addAttribute("extRoles", extRoles);
        return "role/role_list";
    }

    @RequestMapping("/role_add")
    public String role_add(Model model) {
        List<ModuleInfo> moduleInfos = roleService.selectModuleAll();
        model.addAttribute("moduleInfos", moduleInfos);
        return "role/role_add";
    }

    @RequestMapping("/addRole")
    public String addRole(@Validated ExtRole extRole, BindingResult br, Model model) {
        if (br.hasErrors()) {
            FieldError name = br.getFieldError("name");
            model.addAttribute("nameError", name);
            return "forward:/role/role_add";
        }
        RoleInfo reRoleInfo = roleService.selectRoleByName(extRole.getName());
        if (reRoleInfo != null) {
            if (reRoleInfo.getRoleId() != null || reRoleInfo.getRoleId() != 0) {
                model.addAttribute("reNameError", "该角色已经被注册过了");
                return "forward:/role/role_add";
            }
        }
        if ("".equals(extRole.getModule_names()) || extRole.getModule_names() == null) {
            model.addAttribute("moduleError", "至少选择一个权限");
            return "forward:/role/role_add";
        }
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setName(extRole.getName());
        roleService.insert(roleInfo);
        t1(extRole);
        return "forward:/role/role_list_findAll";
    }

    @RequestMapping("/deleteRole")
    public void deleteRole(int role_id) {
        roleService.deleteByPrimaryKey(role_id);
        roleService.deleteModule_id(role_id);
    }

    @RequestMapping("/role_modi/{id}")
    public String role_modi(@PathVariable int id, Model model) {
        System.out.println(id);
        List<ModuleInfo> moduleInfos = roleService.selectModuleAll();
        ExtRole extRole = roleService.selectRoleByRoleId(id);
        System.out.println(extRole);
        if (extRole.getModule_names() != null) {
            List<String> results = Arrays.asList(extRole.getModule_names().split(","));
            model.addAttribute("results", results);
        }
        model.addAttribute("moduleInfos", moduleInfos);
        model.addAttribute("extRole", extRole);
        return "role/role_modi";
    }

    @RequestMapping("/updateRole")
    public String updateRole(@Validated ExtRole extRole, BindingResult br, Model model) {
        if (br.hasErrors()) {
            FieldError name = br.getFieldError("name");
            model.addAttribute("nameError", name);
            return "forward:/role/role_add";
        }
        if ("".equals(extRole.getModule_names()) || extRole.getModule_names() == null) {
            model.addAttribute("moduleError", "至少选择一个权限");
            return "forward:/role/role_add";
        }

        deleteRole(extRole.getRole_id());

        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setName(extRole.getName());
        roleInfo.setRoleId(extRole.getRole_id());
        roleService.insert(roleInfo);
        t1(extRole);
        return "forward:/role/role_list_findAll";
    }

    private void t1(ExtRole extRole){
        String module_names = extRole.getModule_names();
        List<String> results = Arrays.asList(module_names.split(","));
        RoleInfo roleInfo1 = roleService.selectRoleByName(extRole.getName());
        for (String result : results) {
            ModuleInfo moduleInfo = roleService.selectModuleByName(result);
            System.out.println(moduleInfo);
            RoleModule roleModule = new RoleModule();
            roleModule.setRoleId(roleInfo1.getRoleId());
            roleModule.setModuleId(moduleInfo.getModuleId());
            roleService.insertRM(roleModule);
        }
    }



}
