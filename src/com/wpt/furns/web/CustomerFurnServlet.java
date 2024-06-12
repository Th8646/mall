package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/6/12 21:14
 */

import com.wpt.furns.entity.Furn;
import com.wpt.furns.entity.Page;
import com.wpt.furns.service.FurnService;
import com.wpt.furns.service.impl.FurnServiceImpl;
import com.wpt.furns.utils.DataUtils;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customerFurnServlet")
public class CustomerFurnServlet extends BasicServlet {
    // 定义FurnService属性
    private FurnService furnService = new FurnServiceImpl();

    /**
     * 处理分页显示家居信息的API
     *
     * @param request
     * @param response
     * @throws Exception
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取参数
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用service方获取page对象
        Page<Furn> page = furnService.page(pageNo, pageSize);
        //3.将page放入request域
        request.setAttribute("page", page);
        //4.请求转发到furn_manage.jsp
        request.getRequestDispatcher("/views/customer/index.jsp").forward(request, response);
    }
}