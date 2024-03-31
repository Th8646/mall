package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/3/28 23:11
 */

import com.wpt.furns.entity.Member;
import com.wpt.furns.service.MemberService;
import com.wpt.furns.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private String message;
    private MemberService memberService = new MemberServiceImpl();

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //System.out.println("loginServlet被嗲用");
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (memberService.login(new Member(null, username, password, null)) != null) {
            //请求重定向
            request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request, response);
            //System.out.println("用户账号密码正确，可以登录");
        } else {
            //登录错误信息回显前端  Servlet&&JSP
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
           //System.out.println("null，登录失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doGet(request, response);
    }
}