<%@page import="com.bookshop.value.OrderInfoValue"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//订单的详细信息取出

OrderInfoValue oib=(OrderInfoValue)request.getAttribute("detailbean");
%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    


  </head>
  
  <body topmargin="0" background="../images/bg.bmp">
    <center>
    <table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="../Mainbook/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellpadding="0" cellspacing="0" class="abc">
      <tr>
        <td colspan="9" align="center">图片</td>
        </tr>
      <tr>
        <td colspan="9" align="center">订单详细信息</td>
        </tr>
      <tr align="center">
        <td>订单号</td>
        <td>收货人</td>
        <td>收货地址</td>
        <td>邮编</td>
        <td>电话</td>
        <td>总价</td>
        <td>用户名</td>
        <td>电子邮件</td>
        <td>&nbsp;</td>
      </tr>
      <tr align="center">
        <td><%=oib.getOrdersId() %></td>
        <td><%=oib.getTruename() %></td>
        <td><%=oib.getAddress() %></td>
        <td><%=oib.getPostcode() %></td>
        <td><%=oib.getPhone() %></td>
        <td>¥<%=oib.getTotalPrice() %></td>
        <td><%=oib.getUsername() %></td>
        <td><%=oib.getEmail() %></td>
        <td><a href="ShowOrderDetail?orderId=7">查看详情</a></td>
      </tr>
      <tr>
        <td colspan="9" align="center">您的订单已经完成，服务器将在稍后时候向您的电子邮箱发送确认信息，并确认订单信息。</td>
        </tr>
    </table></td>
  </tr>
  
</table>
    </center>
  </body>
</html>