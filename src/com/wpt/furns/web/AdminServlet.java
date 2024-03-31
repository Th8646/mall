package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/3/31 15:11
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

@WebServlet(urlPatterns = "/adminServlet")
public class
AdminServlet extends BasicServlet {
    MemberService memberService = new MemberServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        Member member = new Member(null, username, password, null);
//        Member loginUser = memberService.login(member);
//        System.out.println(loginUser.getRole());
//        if (loginUser != null && loginUser.getRole() == "admin") {
        request.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(request, response);
//        } else {
//            request.getRequestDispatcher("/views/manage/manage_login.jsp").forward(request, response);
//        }
    }
}