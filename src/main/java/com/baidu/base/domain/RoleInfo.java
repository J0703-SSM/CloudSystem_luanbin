package com.baidu.base.domain;



public class RoleInfo {

    private Integer roleId;
    private String name;

    public RoleInfo(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }

    public RoleInfo() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}