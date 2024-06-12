<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/6/12
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--直接请求customerFurnServlet获取要显示的分页数据--%>
<jsp:forward page="/customerFurnServlet?action=page&pageNo=1"></jsp:forward>