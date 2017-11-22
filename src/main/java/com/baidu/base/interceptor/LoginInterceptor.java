package com.baidu.base.interceptor;

import com.baidu.base.domain.Admin_info;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dllo on 2017/11/13.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url = request.getRequestURI();//获取请求路径
        if (url.indexOf("login") != -1 || url.indexOf("getVerifyCode") !=-1) {
            return true;//放行
        }
        //获取session对象
        ServletContext servletContext = request.getServletContext();
        Admin_info login = (Admin_info) servletContext.getAttribute("login");
        if (login == null) {
            //如果没有登录过, 需要转发到登录界面
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
