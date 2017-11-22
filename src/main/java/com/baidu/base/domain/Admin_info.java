package com.baidu.base.domain;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by dllo on 2017/11/13.
 */
public class Admin_info {
    private int id;
    @NotBlank(message = "账号不能为空")
    @Size(min = 3,max = 8,message = "账户长度必须是3-8位字符串")
    private String admin_code;
    @NotBlank(message = "密码不能为空")
    @Size(min = 3,max = 8,message = "密码长度必须是3-8位字符串")
    private String password;
    @NotBlank(message = "姓名不能为空")
    private String name;

//    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$",message = "手机号格式不正确" )
    private String telephone;
//    @Pattern(regexp = "/^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$/",message = "邮箱格式不正确")
    private String email;
    private String enrolldate;
    private String code;

    public Admin_info() {
    }

    public Admin_info(String admin_code, String password, String name, String telephone, String email, String enrolldate) {
        this.admin_code = admin_code;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }

    public Admin_info(int id, String admin_code, String password, String name, String telephone, String email, String enrolldate) {
        this.id = id;
        this.admin_code = admin_code;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.enrolldate = enrolldate;
    }

    @Override
    public String toString() {
        return "Admin_info{" +
                "id=" + id +
                ", admin_code='" + admin_code + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate='" + enrolldate + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin_code() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code = admin_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(String enrolldate) {
        this.enrolldate = enrolldate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
