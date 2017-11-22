package com.baidu.base.domain.ext;

import com.baidu.base.domain.Admin_info;

import java.util.List;

/**
 * Created by dllo on 2017/11/14.
 */
public class ExtAdmin extends Admin_info{
    private String role_names;

    private List<String> strings;

    @Override
    public String toString() {
        return "ExtAdmin{" +
                "role_names='" + role_names + '\'' +
                "} " + super.toString();
    }

    public String getRole_names() {
        return role_names;
    }

    public void setRole_names(String role_names) {
        this.role_names = role_names;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
