package com.baidu.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 2017/11/14.
 */
@Controller
public class BaseController {

    @RequestMapping({"/index"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/logint","/"})
    public String login() {
        return "login";
    }

    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @RequestMapping("/nopower")
    public String nopower() {
        return "nopower";
    }
}
