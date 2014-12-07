<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	<!--
		
		
		function Login(){
			window.open("../Mainbook/mainbook.jsp","_self");
		}
		
		//响应点击购买货物的事件
		function Register(){
			
		   window.open("../Register/register.jsp","_self");
		}
	
	-->
	</script>
</head>
  
  <body topmargin="0" background="../images/bg.bmp">
  <fmt:setBundle basename="com.bookshop.message.messages"/>
    <center>
    <table width="80%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center">
    <jsp:include flush="true" page="../Mainbook/head.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td align="center"><table width="100%" border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td align="center"><img src="../images/cartnavi-2.gif" width="599" height="49" /></td>
      </tr>
      <tr>
        <td align="center">
        <form action="../Login/Login.do" method="post">
        <table width="40%" border="1" cellpadding="0" cellspacing="0" bordercolor="#9999FF" class="abc">
          <tr>
            <td colspan="2" align="center"><img src="../images/dl.gif" width="149" height="63" /></td>
            </tr>
          <tr>
            <td width="39%" align="right"><fmt:message key="com.bookshop.custom.action.custom.username"> </fmt:message></td>
            <td width="61%" align="left"><input name="username" type="text" size="15" /></td>
          </tr>
          <tr>
            <td align="right"><fmt:message key="com.bookshop.custom.action.custom.password"> </fmt:message></td>
            <td align="left"><input name="password" type="password" size="15" /></td>
          </tr>
          <tr>
            <td align="right"><input type="submit" name="Submit" value="用户登录" /></td>
            <td> <input name="Submit2" type="button" onclick="Register();" value="用户注册" /></td>
          </tr>
        </table>
        </form>
        </td>
      </tr>
      <tr>
        <td align="right"><img src="../images/cartnext.gif" width="87" height="19" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    
  </tr>
</table>
    </center>
  </body>
</html>
