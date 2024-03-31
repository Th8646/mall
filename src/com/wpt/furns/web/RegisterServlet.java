package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/3/28 15:39
 */

import com.wpt.furns.entity.Member;
import com.wpt.furns.service.MemberService;
import com.wpt.furns.service.impl.MemberServiceImpl;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    private String message;
    private MemberService memberService = new MemberServiceImpl();

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("RegisterServlet被调用");
        // 获取前端注册的表单信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //判断用户名是否可用
        if (!(memberService.isExistMember(username))) {
            //注册
            //System.out.println("用户名" + username + "不存在，可以注册");
            //System.out.println("注册成功");
            Member member = new Member(null, username, password, email);
            //请求转发
            if (memberService.registerMember(member)) {
                request.getRequestDispatcher("/views/member/register_ok.html").forward(request, response);
            }
        } else {
            //返回注册页面
            //System.out.println("用户名" + username + "存在，不可以注册");
            //System.out.println("注册失败");
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);

        }

    }
}