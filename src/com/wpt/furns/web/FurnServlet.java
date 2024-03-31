package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/3/31 0:01
 */

import com.wpt.furns.entity.Furn;
import com.wpt.furns.service.FurnService;
import com.wpt.furns.service.impl.FurnServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/furnServlet")
public class FurnServlet extends BasicServlet {
    FurnService furnService = new FurnServiceImpl();

    /**
     * 使用模板设计模式+反射+动态绑定的调用方式到list方法
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 测试访问
        // System.out.println("FurnServlet的list方法被调用");
        List<Furn> furns = furnService.queryFurns();
        // 将furns集合放入request域
        request.setAttribute("furns", furns);
        // 请求转发
        request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request, response);
    }
}


