package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/3/30 16:57
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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/memberServlet")
public class MemberServlet extends BasicServlet {
    private String message;
    private MemberService memberService = new MemberServiceImpl();

    public void init() {

    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String action = request.getParameter("action");
//        if ("login".equals(action)) {
//            login(request, response);
//        } else if ("register".equals(action)) {
//            register(request, response);
//        } else {
//            //提示信息
//            response.getWriter().write("请求参数action错误");
//        }
//    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        this.doGet(request, response);
//    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //System.out.println("loginServlet被嗲用");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Member member = memberService.login(new Member(null, username, password, null));

        if (member != null) {
            //请求重定向
            HttpSession session = request.getSession();
            session.setAttribute("member", member);
            request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request, response);
            //System.out.println("用户账号密码正确，可以登录");
        } else {
            //登录错误信息回显前端  Servlet&&JSP
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
            //System.out.println("null，登录失败");
        }

    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //System.out.println("RegisterServlet被调用");
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