package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 17:22
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @projectName: jiaju_mall
 * @package: com.wpt.furns.web
 * @className: BasicServlet
 * @author: wpt
 * @description: TODO
 * @date: 2024/3/30 17:22
 * @version: 1.0
 */
public abstract class BasicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //获取隐藏域的action
        String action = request.getParameter("action");
        //System.out.println("action= " + action);

        //使用反射获取当前对象的方法
        //this指请求的真实的Servlet
        //declaredMethod方法对象是当前请求的servlet对应的“action”的方法，该方法对象是变化的，根据用户请求而定
        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(action,
                    HttpServletRequest.class, HttpServletResponse.class);
            //  System.out.println("getDeclaredMethod = " + declaredMethod);
            //使用方法对象进行反射调用
            declaredMethod.invoke(this, request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

