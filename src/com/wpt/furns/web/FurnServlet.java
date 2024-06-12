package com.wpt.furns.web;/**
 * @author wpt@onlying.cn
 * @date 2024/3/31 0:01
 */

import com.wpt.furns.entity.Furn;
import com.wpt.furns.entity.Page;
import com.wpt.furns.service.FurnService;
import com.wpt.furns.service.impl.FurnServiceImpl;
import com.wpt.furns.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
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

    /**
     * 处理添加家居的请求
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 测试访问
        // System.out.println("FurnServlet的add方法被调用");
//        String name = request.getParameter("name");
//        String maker = request.getParameter("maker");
//        String price = request.getParameter("price");
//        String sales = request.getParameter("sales");
        // 后端数据校验方案1：使用异常对可能发生错误的地方逐一进行捕获
//        try{
//            int i = Integer.parseInt(sales);
//        }catch (NumberFormatException e){
//            request.setAttribute("msg","销量数据格式不正确");
//            request.getRequestDispatcher("/views/manage/furn_add.jsp").forward(request,response);
//            return;
//        }
//        String stock = request.getParameter("stock");

        // 方案2：直接捕获所有异常
//        try{
//            furn = new Furn(null, name, maker, new BigDecimal(price),
//                    new Integer(sales), new Integer(stock), "assets/images/product-image/default.jpg");
//
//
//
//        }catch (NumberFormatException e){
//            request.setAttribute("msg","数据格式不正确");
//            request.getRequestDispatcher("/views/manage/furn_add.jsp").forward(request,response);
//            return;
//        }
//      使用BeanUtils将前端提交的数据封装

        // try {
        //     要求表单提交的数据字段名需要和封装的JavaBean的属性名一致
        //
        //     BeanUtils.populate(furn, request.getParameterMap());
        // } catch (Exception e) {
        //     throw new RuntimeException(e);
        // }
        //  自动将提交的数据封装到Furn
        Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());
        System.out.println("furn = " + furn);
        // 方案3：直接使用SpringMVC 的数据校验框架 JSR303  Hibernate Validator
        furnService.addFurn(furn);
        // 显示更新家居列表业,重新调用list方法
        // 重定向实际是浏览器发送第二次请求，可以避免因为刷新造成了数据重复提交
//        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=page&pageNo=" + request.getParameter("pageNo"));
//        request.getRequestDispatcher("/manage/furnServlet?action=list").forward(request,response);

    }

    protected void del(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 防止接收的id不是数字字符串，例如hello等
        // 使用DataUtils.paKrseInt进行转换，可以转数字字符串就转，否则返回默认值0
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        furnService.deleteFurnById(id);
        // 重定向到家居列表页
//        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
        response.sendRedirect(request.getContextPath()
                + "/manage/furnServlet?action=page&pageNo="
                + request.getParameter("pageNo"));


    }

    /**
     * 处理回显家居信息的请求
     *
     * @param request
     * @param response
     */
    protected void showFurn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = DataUtils.parseInt(request.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);
        // System.out.println(furn);
        // 放入request域
        request.setAttribute("furn", furn);
        // 请求转发到furn_update.jsp
        // 在请求转发页面 furn_update.jsp 通过param隐藏域取出 manage_furn.jsp中传入request请求的pageNo参数
        request.getRequestDispatcher("/views/manage/furn_update.jsp").forward(request, response);
    }


    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将提交修改的家居信息封装成Furn对象
        Furn furn = DataUtils.copyParamToBean(request.getParameterMap(), new Furn());
        System.out.println("Furn=" + furn);
        furnService.updateFurn(furn);
        // 重定向
        // 考虑分页，带上pageNo至分页显示中的当前页
//        response.sendRedirect(request.getContextPath() + "/manage/furnServlet?action=list");
        response.sendRedirect(request.getContextPath() +
                "/manage/furnServlet?action=page&pageNo="
                + request.getParameter("pageNo"));
    }

    /**
     * 处理分页显示请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        int pageNo = DataUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用service方获取page对象
        Page<Furn> page = furnService.page(pageNo, pageSize);
        //3.将page放入request域
        request.setAttribute("page", page);
        //4.请求转发到furn_manage.jsp
        request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request, response);


    }
}



