<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <% 
       Integer Onlinenum=(Integer) application.getAttribute("Onlinenum");
	   application.setAttribute("flux", ++Onlinenum);	
	   System.out.println("总访问次数"+Onlinenum);

     
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆失败</title>
</head>
<body>
<tr>登陆失败</tr>
<tr>账号或密码错误</tr>
</body>
</html>