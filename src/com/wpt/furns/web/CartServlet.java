package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/7/12 15:10
 */

import com.wpt.furns.entity.Cart;
import com.wpt.furns.entity.CartItem;
import com.wpt.furns.entity.Furn;
import com.wpt.furns.service.impl.FurnServiceImpl;
import com.wpt.furns.utils.DataUtils;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;

public class CartServlet extends BasicServlet {
    private String message;
    private FurnServiceImpl furnService = new FurnServiceImpl();

    public void init() {

    }


    /**
     * 添加家居数据到购物车
     *
     * @param request
     * @param response
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 得到添加家居的id
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        // 获取到id对应的Furn对象
        Furn furn = furnService.queryFurnById(id);
        // todo    判断，先处理正常逻辑，在处理异常
        if (null == furn) {

        }
        // 根据furn 构建 CartItem
        CartItem item = new CartItem(furn.getId(), furn.getName(), furn.getPrice(), 1, furn.getPrice());
        // 从session中获取Cart对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (null == cart) {//说明当前用户的session中没有cart
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        // 将cartItem加入 cart
        cart.addItem(item);
        System.out.println("cart=" + cart);
        // 添加完毕后，返回到添加家居界面
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);

    }

    /**
     * 更新购物车中的家具数量
     *
     * @param request
     * @param response
     * @throws IOException
     */

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        int count = DataUtils.parseInt(request.getParameter("count"), 1);

        // 获取session中的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (null != cart) {
            cart.updateCount(id, count);
        }
        //回到请求更新购物车页面
        // 添加完毕后，返回到添加家居界面
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }


    protected void delItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        //获取cart的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (null != cart) {
            cart.delItem(id);
        }
        //返回请求删除购物车页面
        response.sendRedirect(request.getHeader("Referer"));
    }


    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session中的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (null != cart) {
            cart.clear();
        }
        //返回请求删除购物车页面
        response.sendRedirect(request.getHeader("Referer"));
    }
}