package com.baidu.base.domain.ext;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by dllo on 2017/11/14.
 */
public class ExtRole {
    private int role_id;
    @NotBlank(message = "角色名不能为空")
    private String name;
    private String module_names;

    public ExtRole() {
    }

    public ExtRole(int role_id, String name, String module_names) {
        this.role_id = role_id;
        this.name = name;
        this.module_names = module_names;
    }

    @Override
    public String toString() {
        return "ExtRole{" +
                "role_id=" + role_id +
                ", name='" + name + '\'' +
                ", module_names='" + module_names + '\'' +
                '}';
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModule_names() {
        return module_names;
    }

    public void setModule_names(String module_names) {
        this.module_names = module_names;
    }
}
